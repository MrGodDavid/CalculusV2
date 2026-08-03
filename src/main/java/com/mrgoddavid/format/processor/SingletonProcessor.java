package com.mrgoddavid.format.processor;

import com.mrgoddavid.format.annotation.SingletonClass;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * Annotation processor for {@link SingletonClass}.
 *
 * <p>This processor validates that classes annotated with
 * {@code @SingletonClass} satisfy the following rules:
 *
 * <ul>
 *     <li>Must be a class (not interface, enum, annotation, or record)</li>
 *     <li>Must not be abstract</li>
 *     <li>Every constructor must be private</li>
 * </ul>
 *
 * @author Mr. GodDavid
 * @since 7/25/2026
 */
public class SingletonProcessor extends AbstractProcessor {

    /**
     * Empty constructor of this class.
     */
    public SingletonProcessor() {
    }

    /**
     * Compiler message reporter.
     */
    private Messager messager;

    /**
     * Initializes the processor.
     *
     * @param processingEnv processing environment.
     */
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.messager = processingEnv.getMessager();
    }

    /**
     * Returns the annotations this processor supports.
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(SingletonClass.class.getCanonicalName());
    }

    /**
     * Supports the newest Java version available.
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        messager.printMessage(
                Diagnostic.Kind.NOTE,
                "SingletonClassProcessor is running!"
        );

        for (Element element : roundEnvironment.getElementsAnnotatedWith(SingletonClass.class)) {
            if (!(element instanceof TypeElement typeElement)) {
                continue;
            }

            validateClass(typeElement);
        }
        return true;
    }

    /**
     * Validates one singleton class.
     */
    private void validateClass(TypeElement clazz) {
        if (clazz.getKind() != ElementKind.CLASS) {
            error(clazz, "@SingletonClass may only be applied to classes.");
            return;
        }

        if (clazz.getModifiers().contains(Modifier.ABSTRACT)) {
            warning(clazz, "Singleton classes should not be abstract.");
        }

        boolean foundConstructor = false;
        for (Element member : clazz.getEnclosedElements()) {
            if (member.getKind() != ElementKind.CONSTRUCTOR) {
                continue;
            }

            foundConstructor = true;
            ExecutableElement constructor = (ExecutableElement) member;
            validateConstructor(constructor);
        }

        if (!foundConstructor) {
            warning(clazz, "Constructors of a @SingletonClass must be private.");
        }
    }

    private void validateConstructor(ExecutableElement constructor) {
        if (!constructor.getModifiers().contains(Modifier.PRIVATE)) {
            warning(constructor, "@SingletonConstructor must be private.");
        }
    }

    private void warning(Element clazz, String message) {
        messager.printMessage(Diagnostic.Kind.WARNING, message, clazz);
    }

    private void error(Element clazz, String message) {
        messager.printMessage(Diagnostic.Kind.ERROR, message, clazz);
    }
}
