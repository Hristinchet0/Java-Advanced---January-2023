package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        Map<String, List<Field>> fieldsMap = getFieldsMap();
//
//        Consumer<Field> printerField = field -> System.out.println(Modifier.toString(field.getModifiers()) + " "
//                + field.getType().getSimpleName() + " " + field.getName());
//
//        String command = scanner.nextLine();
//
//        while (!command.equals("HARVEST")) {
//
//            switch (command) {
//                case "private":
//                    fieldsMap.get("private").forEach(printerField);
//                    break;
//                case "protected":
//                    fieldsMap.get("protected").forEach(printerField);
//                    break;
//                case "public":
//                    fieldsMap.get("public").forEach(printerField);
//                    break;
//                case "all":
//                    fieldsMap.get("all").forEach(printerField);
//                    break;
//            }
//
//            command = scanner.nextLine();
//        }
//
//    }
//
//    private static Map<String, List<Field>> getFieldsMap() {
//        Map<String, List<Field>> map = new HashMap<>();
//        map.put("private", new ArrayList<>());
//        map.put("public", new ArrayList<>());
//        map.put("protected", new ArrayList<>());
//
//        List<Field> allFields = Arrays.asList(RichSoilLand.class.getDeclaredFields());
//        map.put("all", allFields);
//
//        allFields.forEach(field -> {
//            String modifier = Modifier.toString(field.getModifiers());
//            switch (modifier) {
//                case "private":
//                    map.get("private").add(field);
//                    break;
//                case "protected":
//                    map.get("protected").add(field);
//                    break;
//                case "public":
//                    map.get("public").add(field);
//                    break;
//            }
//        });
//
//        return map;
//    }

        Scanner scanner = new Scanner(System.in);
        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] declaredField = clazz.getDeclaredFields();
        Consumer<Field> printer = field -> System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
        String argument = scanner.nextLine();

        while (!argument.equals("HARVEST")) {
            Field[] fields = declaredField;
            if (!argument.equals("all")) {
                fields = getFields(declaredField, argument);
            }
            for (Field field : fields) {
                printer.accept(field);
            }
            argument = scanner.nextLine();
        }
    }

    private static Field[] getFields(Field[] declaredField, String argument) {
        return Arrays.stream(declaredField)
                .filter(f -> Modifier.toString(f.getModifiers()).startsWith(argument))
                .toArray(Field[]::new);
    }
}
