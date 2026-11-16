
class Solution {

    private static final String[] below20 = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"
    };

    private static final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();
        int index = 0;

        while (num > 0) {

            if (num % 1000 != 0) {
                String part = convert(num % 1000);

                result.insert(0, part + 
                    (thousands[index].isEmpty() ? "" :
                    " " + thousands[index]) + " ");
            }

            num /= 1000;
            index++;
        }

        return result.toString().trim();
    }

    private String convert(int num) {

        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return below20[num];
        }

        if (num < 100) {
            return tens[num / 10] +
                (num % 10 == 0 ? "" : " " + convert(num % 10));
        }

        return below20[num / 100] + " Hundred" +
            (num % 100 == 0 ? "" : " " + convert(num % 100));
    }
}
