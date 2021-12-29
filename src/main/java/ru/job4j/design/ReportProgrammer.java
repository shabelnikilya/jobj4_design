package ru.job4j.design;

import java.util.function.Predicate;

public class ReportProgrammer implements Report {
    private final Store store;

    public ReportProgrammer(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String del = System.lineSeparator();
        StringBuilder str = new StringBuilder();
        getHtmlTextBeforeAdd(str, del);
        String rowInTableHtml = "                <td>%s</td>";
        for (Employee em : store.findBy(filter)) {
            if (filter.test(em)) {
                str.append("            <tr>").append(del)
                        .append(String.format(rowInTableHtml, em.getName())).append(del)
                        .append(String.format(rowInTableHtml, em.getHired().getTime())).append(del)
                        .append(String.format(rowInTableHtml, em.getFired().getTime())).append(del)
                        .append(String.format(rowInTableHtml, em.getSalary())).append(del)
                        .append("            </tr>").append(del);
            }
        }
        afterAddEmployees(str, del);
        return str.toString();
    }

    public static void getHtmlTextBeforeAdd(StringBuilder str, String del) {
        str.append("<!DOCTYPE html>").append(del)
                .append("<html lang=\"ru\">").append(del)
                .append("    <head>").append(del)
                .append("        <meta charset=\"utf-8").append(del)
                .append("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"").append(del)
                .append("        <title>Report</title>").append(del)
                .append("    </head>").append(del)
                .append("    <body>").append(del)
                .append("        <table>").append(del)
                .append("            <tr>").append(del)
                .append("                <th>Name</th>").append(del)
                .append("                <th>Hired</th>").append(del)
                .append("                <th>Fired</th>").append(del)
                .append("                <th>Salary</th>").append(del)
                .append("            </tr>").append(del);
    }

    public static void afterAddEmployees(StringBuilder str, String del) {
        str.append("        </table>").append(del)
                .append("    </body>").append(del)
                .append("</html>").append(del);
    }
}
