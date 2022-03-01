package reactor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Constans {
    public static final String incorrectValue = "-1ABc";

    public static final String INFORMATION_MESSAGE = "You are the Tech Commander of RBMK reactor power plant. Your task is to perform the reactor test. Bring the power level above 1000 but below 1500 and keep the reactor Operational. Use /{key}/control_room/analysis to peek at reactor core. Use /{key}/control_room to see full info about the reactor. Check in at the /desk to get your key to control room. Put in fuel rods or pull out control rods to raise the power. Put in control rods or pull out fuel rods to decrease the power. There are 12 flags to find. Good luck Commander. ";
    public static final String CHECK_IN_MESSAGE = "Take the key to your control room. Keep it safe. use it as " +
            "resource path to check on your RMBK-100 reactor! Use following: /{key}/control_room to gain knowledge how to operate reactor. You may see if the core is intact here: /{key}/reactor_core . If anything goes wrong push AZ-5 safety button to put all control rods in place!Good luck Commander.";
    public static final String REACTOR_DESCRIPTION = "Rieaktor Bolszoj Moszcznosti Kanalnyj - 1000 MW";
    public static final String CAN_NOT_PASS = "You're can't get pass this door comrade! ${flag_sneaky_rat}";
}
