package bean;

public class Word {
    private String word;
    private int langCode;

    public Word() {
    }

    public Word(String word, int langCode) {
        this.word = word;
        this.langCode = langCode;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLangCode() {
        return langCode;
    }

    public void setLangCode(int langCode) {
        this.langCode = langCode;
    }
}
