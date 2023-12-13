package chatbot;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to handle user input. <br /><br />
 * It specifically provides potential answers to user requests.
 */
public class Database {
    public Map<String, String> responses;

    public Database() {
        responses = new HashMap<>();
        responses.putAll(addTeams());
        responses.putAll(addPlayers());
    }

    public Map<String, String> addTeams() {
        Map<String, String> teams = new HashMap<>();
        String defaultResponse = "Great! My favorite team is the Milwaukee Bucks!";
        String specialResponse = "Awesome, me too!";
        teams.put("milwaukee", specialResponse);
        teams.put("bucks", specialResponse);
        teams.put("lakers", defaultResponse);
        teams.put("clippers", defaultResponse);
        teams.put("portland", defaultResponse);
        teams.put("blazers", defaultResponse);
        teams.put("oklahoma", defaultResponse);
        teams.put("thunders", defaultResponse);
        teams.put("nicks", defaultResponse);
        teams.put("york", defaultResponse);
        teams.put("brooklyn", defaultResponse);
        teams.put("nets", defaultResponse);
        teams.put("miami", defaultResponse);
        teams.put("heat", defaultResponse);
        String[] teamNames = {
            "san antonio", "spurs", "boston", "celtics", "cleveland", "cavaliers",
            "golden state", "warriors", "chicago", "bulls", "dallas", "mavericks", "houston", "rockets", "orlando", 
            "magic", "utah", "jazz", "detroit", "pistons", "denver", "nuggets", "sacramento", "kings", "orleans", "pelicans", 
            "phoenix", "suns", "minnesota", "timberwolves", "indiana", "pacers", "memphis", 
            "grizzlies", "toronto", "raptors", "washington",
            "wizards", "charlotte", "hornets", "atlanta", "hawks", "philadelphia", "76ers"
        };
        for (String t : teamNames) {
            teams.put(t, defaultResponse);
        }
        return teams;
    }

    public Map<String, String> addPlayers() {
        Map<String, String> players = new HashMap<>();
        String specialResponse = "Wow! This is my favorite player too!";
        String defaultResponse = "Great, my favorite player is Giannis Antetokounmpo.";
        players.put("giannis", specialResponse);
        players.put("antetokounmpo", specialResponse);
        players.put("lebron", defaultResponse);
        players.put("james", defaultResponse);
        players.put("mj", defaultResponse);
        players.put("jordan", defaultResponse);
        players.put("kobe", "RIP mamba, one of my favorite players too.");
        players.put("bryant", "RIP mamba, one of my favorite players too.");
        players.put("shaq", defaultResponse);
        players.put("shaquille", defaultResponse);
        players.put("bird", defaultResponse);
        String[] playerNames = {
            "curry", "thompson", "davis", "poole", "iguodala", "paul", "durant", "harden", "irving", 
            "morant", "jokic", "doncic", "wembanyama", "lillard", "george", "griffin", "tucker", "kawhi", "leonard", "westbrook", 
            "butler", "johnson", "russell", "pippen", "rodman", "kerr", "wilt", "chamberlain", "robinson", "iverson", "derrick",
            "rose", "allen", "dwayne", "wade", "kareem", "jabbar", "embiid", ""
        };
        for (String p : playerNames) {
            players.put(p, defaultResponse);
        }
        return players;
    }
}
