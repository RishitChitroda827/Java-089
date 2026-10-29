public class ChatFilter {

    public static String filter(String logs[], String keyWord){

        int count = 0;
        StringBuilder report = new StringBuilder();

        for (String s : logs){
            String[] parts = s.split(" ",3);

            if (parts.length < 3){
                continue;
            }

            String time = parts[0];
            String name = parts[1];
            String msg = parts[2];

            if (msg.toLowerCase().contains(keyWord.toLowerCase())){
                count++;
                report.append(time);
                report.append(" ");
                report.append(name);
                report.append(" ");
                report.append(msg);
                report.append(" ");
            }
        }

        return "Matches: " + count + "\n" + report.toString();
    }

}