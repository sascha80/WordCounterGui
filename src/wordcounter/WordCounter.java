package wordcounter;

public class WordCounter {

	public static int countWords(String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}
		String[] words = text.trim().split("\\s+");
		return words.length;
		
	}
	
	public static int countChars(String text) {
	if (text == null || text.isEmpty()) {
		return 0;
		
	}
	return text.length();

	}
	
	public static int countSentences(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] sentences = text.split("[.!?]");
        return sentences.length;
    }

}
