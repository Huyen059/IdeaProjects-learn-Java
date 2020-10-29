// Do not remove imports

import java.lang.reflect.*;
import java.util.Set;
import java.util.Scanner;

class ListParameterInspector {
    // Do not change the method
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String methodName = scanner.next();

        ListParameterInspector inspector = new ListParameterInspector();
        inspector.printParameterType(new TestClass(), methodName);
    }

    public void printParameterType(TestClass obj, String methodName) throws Exception {
        ParameterizedType type = (ParameterizedType) obj.getClass().getDeclaredMethod(methodName)
                .getGenericReturnType();
        WildcardType type1 = (WildcardType) type.getActualTypeArguments()[0];

        System.out.println(type1.getUpperBounds()[0].getTypeName());
    }
}


