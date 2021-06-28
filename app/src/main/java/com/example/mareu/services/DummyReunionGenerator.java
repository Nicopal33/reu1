package com.example.mareu.services;

import com.example.mareu.models.Reunion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public abstract class DummyReunionGenerator {

    static List<Reunion> generateReunions() {return new ArrayList<>(DUMMY_REUNION);}

    public static List<Reunion> DUMMY_REUNION = Arrays.asList(
            new Reunion (1, "Commercial",new Date(), "Salle 2" , "8h00", "9h00", "popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com","https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/9_Emoji_happy_smiley_surprised_emoticon-128.png"),
            new Reunion (2, "Marketing", new Date(), "Salle 1", "9h30", "11h00", "popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com","https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/11_Emoticons_smiley_laughing_face_face_smiley_laughing_tears-128.png"),
            new Reunion (3, "Projets", new Date(), "Salle 4", "14h00", "16h00 " ,"popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com","https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/1_Emoji_happy_smiley_surprised_emoticon-128.png"),
            new Reunion (4, "Commercial", new Date(), "Salle 2", "11h00", "12h00", "popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com","https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/6_Emoji_exhausted_emoticon_tired_emoji_tired_face_sad_unhappy-128.png"),
            new Reunion (5, "Compta",new Date(), "Salle 1", "15h00", "16h00", "popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com","https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/3_Astonished_face_hushed_face_surprised_wondering_confused-128.png"),
            new Reunion (6, "Commercial",new Date(), "Salle 3", "11h00", "12h00", "popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com","https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/2_Confused_sad_emoji_sad_face_face_expression_puzzled-128.png"),
            new Reunion (7, "Marketing",new Date(), "Salle 4", "9h00", "11h00", "popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com","https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/7_Excited_laughing_smiley_happy_joyful-128.png"),
            new Reunion (8, "Conges", new Date(), "Salle 1", "11h30", "13h00", "popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com","https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/8Excited_laughing_smiley_happy_joyful-128.png"),
            new Reunion (9, "Bilan financier",new Date() , "Salle 3", "10h30", "12h30", "popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com","https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/12_Emoji_exhausted_emoticon_tired_emoji_tired_face_sad_unhappy-128.png"),
            new Reunion (10, "Travaux", new Date(), "Salle 4" , "9h00", "11h00", "popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com","https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/5_Confused_sad_emoji_sad_face_face_expression_puzzled-128.png"),
            new Reunion (11, "Marketing", new Date(), "Salle 1", "10h30", "12h00", "popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com","https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/4_Emoji_exhausted_emoticon_tired_emoji_tired_face-128.png"),
            new Reunion (12, "Compta", new Date(), "Salle 2", "14h30", "16h00", "popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com","https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/10_Depressed_sad_face_emoticon_sad_smiley_unhappy-128.png"),
            new Reunion (13, "Vacances", new Date(1624838400), "Salle 1", "10h30", "12h00", "popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com","https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/4_Emoji_exhausted_emoticon_tired_emoji_tired_face-128.png"),
            new Reunion (14, "Apero", new Date(1624147200),"Salle2", "14h30", "16h00", "popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com","https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/10_Depressed_sad_face_emoticon_sad_smiley_unhappy-128.png")
        );



    public static List<String> DUMMY_REUNION_IMAGE_RANDOM = Arrays.asList(
            new String("https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/9_Emoji_happy_smiley_surprised_emoticon-128.png"),
            new String("https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/11_Emoticons_smiley_laughing_face_face_smiley_laughing_tears-128.png"),
            new String("https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/10_Depressed_sad_face_emoticon_sad_smiley_unhappy-128.png"),
            new String("https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/6_Emoji_exhausted_emoticon_tired_emoji_tired_face_sad_unhappy-128.png"),
            new String("https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/8Excited_laughing_smiley_happy_joyful-128.png")
    );

}



