package main.entities.help;

import main.exceptions.validation.*;

public class OrganizationName extends EntityName{
    public OrganizationName(String value){
        super(value);
    }

    protected void validate(String value) {
        for(int i = 0; i < value.length(); i++){
            char cur = value.charAt(i);
            if(!Character.isLetter(cur) && !Character.isWhitespace(cur)){
                throw new InvalidCharacterInOrganizationNameValidationException(value);
            }
        }
    }

    protected String normalize(String value){
        String[] words = value.split(" ");
        for(int i = 0; i < words.length; i++){
            words[i] = normalizeWord(words[i]);
        }
        return String.join(" ", words);
    }

    private String normalizeWord(String word){
        word = word.toLowerCase();
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
