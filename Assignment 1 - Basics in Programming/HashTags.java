public class HashTags {
    public static void findHashTagsInText(){
        //asks user to input text, and finds hashtags
        String userTweet = IOScanner.readString("Type your post: ");
        String hashTags = "";

        String[] words = userTweet.split(" "); //break up tweet into words

        int count = 0; //count number of hashtags
        int numWords = words.length; //number of words delimited by space
        String word = "";
        // System.out.println(n);

        for (int i = 0; i < numWords; i++) {
            word = words[i];
            //check if word starts with #
            if (word.startsWith("#")) {
                hashTags = hashTags + " " + word;
                count++;
            }
        }
        //print hashTags
        if (count > 0) {
            System.out.println("Hashtags found:" + hashTags);
        } else {
            System.out.println("No hashtags were typed");
        }
    }
}
