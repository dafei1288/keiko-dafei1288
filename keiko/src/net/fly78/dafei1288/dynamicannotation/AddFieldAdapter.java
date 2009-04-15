/**
 * net.fly78.dafei1288.dynamicannotation
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 3, 2009/11:39:07 AM
 */
package net.fly78.dafei1288.dynamicannotation;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

public class AddFieldAdapter extends ClassAdapter {
    private int accessModifier;
    private String name;
    private String desc;
    private boolean isFieldPresent;

    public AddFieldAdapter(ClassVisitor cv, int accessModifier, String name, String desc) {
        super(cv);
        this.accessModifier = accessModifier;
        this.name = name;
        this.desc = desc;
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc,
            String signature, Object value) {
        if (name.equals(this.name)) {
            isFieldPresent = true;
        }
        return cv.visitField(access, name, desc, signature, value);
    }

    @Override
    public void visitEnd() {
        if (!isFieldPresent) {
            FieldVisitor fv = cv.visitField(accessModifier, name, desc, null, null);
            if (fv != null) {
                fv.visitEnd();
            }
        }
        cv.visitEnd();
    }
}

