package challengePrimer.util;

import lombok.AllArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
public class Util {
    
    public static final String GET_INFORMATION_MESSAGE = "Oi! W'at can I do for ya? In this primer for challenges you'll " +
            "learn how to look for flags. Remember that this is not purely technical task. You'll role play and use your knowledge to find treasures your looking for. If you have any questions - ask. Try and found as many flags as possible.(Five, there are five.) begin with shooting at /tryout. ";
    public static final String TRYOUT_MESSAGE = "Good! Toy have tried to GET a resource.Now you have to GET something else... /flag";
    public static final String FLAG_MESSAGE = "Use your exploratory skills and feel the challenge's theme to obtain flags";
}
