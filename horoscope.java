import java.util.Random;

import org.json.simple.*;

public class horoscope {
    private String text;

    public horoscope(String sign, String name){
        text = populate(sign, name);
    }
    private static String populate(String sign, String name){ 
        String script = manage.readFile("templates.txt");
        JSONObject words = manage.jsonFileConvert("general-words.json");
        JSONObject atrib = manage.jsonFileConvert("sign-words.json");
        atrib = (JSONObject) atrib.get(getSignElement(sign));
        script = script.replaceAll(":break:", "\n\n");
        script = script.replaceAll(":Name:", name);
        script = script.replaceAll(":Zodiac sign:", sign);
        script = replaceTemplate("noun", script, (JSONArray) words.get("noun"));
        script = replaceTemplate("plural noun", script, (JSONArray) words.get("plural_noun"));
        script = replaceTemplate("verb", script, (JSONArray) words.get("verb"));
        script = replaceTemplate("adjective", script, (JSONArray) words.get("adjective"));
        script = replaceTemplate("affirmation", script, (JSONArray) words.get("affirmation"));
        script = replaceTemplate("positive", script, (JSONArray) atrib.get("positive"));
        script = replaceTemplate("negative", script, (JSONArray) atrib.get("negative"));
        script = replaceTemplate("positive other", script, (JSONArray) atrib.get("positive"));
        script = replaceTemplate("negative other", script, (JSONArray) atrib.get("negative"));
        script = replaceTemplate("challenge", script, (JSONArray) atrib.get("challenge"));
        return script;
    }

    private static String getSignElement(String sign){
        if (sign.equals("aries")||sign.equals("leo")||sign.equals("Sagittarius"))
            return "fire";
        if (sign.equals("taurus")||sign.equals("virgo")||sign.equals("capricorn"))
            return "earth";
        if (sign.equals("gemini")||sign.equals("libra")||sign.equals("aquarius"))
            return "air";
        if (sign.equals("cancer")||sign.equals("scorpio")||sign.equals("pisces"))
            return "water";
        assert false;
        return "error";
    }

    private static String replaceTemplate(String type, String script, JSONArray words){
        Random random = new Random(System.currentTimeMillis());
        String a[] = script.split(":");
        int count;
        count = 0;
        for (int i = 0; i < a.length; i++)
        {
            if(a[i].equals(type)){
                count++;
            }
        }
        for(int i = 0; i < count; i++){
            script = script.replaceFirst(':'+type+':', (String) words.get(random.nextInt(words.size() - 1)));
        }
        return script;
    }

    public void display(){
        System.out.println(text);
    }
}