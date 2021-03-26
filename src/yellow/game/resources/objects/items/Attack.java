package yellow.game.resources.objects.items;

import yellow.game.resources.objects.PlayerCharacter;

public class Attack {
    String[] attacks = new String[4];
    String[] audiofiles = new String[4];
    int[] NRGY = {2, 4, 8, 16};
    public int getNRGY(int ix){
        return NRGY[ix];
    }
    public void setNRGY(int ix, int nrgy){
        NRGY[ix] = nrgy;
    }

    int stat; //0 = None // 1 = Strength // 2 = Dexterity // 3 = Magic
    //int statpoints;
    int unlocked = 1;
    public int getUnlocked() {
        return unlocked;
    }
    boolean special;

    public Attack(int stat, String first, String second, String third) {
        attacks[0] = first;
        attacks[1] = second;
        attacks[2] = third;
        this.stat = stat; //0 = None // 1 = Strength // 2 = Dexterity // 3 = Magic
        for(int i = 0; i < attacks.length; i++){
            if(attacks[i] != null){
                addAudio(i);
            }
        }
        for(int i = 0; i < NRGY.length; i++){
            if(i > 0){
                setNRGY(i, (getNRGY(i - 1) * 2));
            } else {
                setNRGY(i, 2);
            }
        }
        updateAttacks();
    }

    public void addSpecial(String fourth) {
        special = true;
        attacks[3] = fourth;
        addAudio(3);
        updateAttacks();
    }

    public void updateAttacks() {
        int statpoints = 0;
        if (this.stat == 1) {
            statpoints = PlayerCharacter.getStrength();
        } else if (this.stat == 2) {
            statpoints = PlayerCharacter.getDexterity();
        } else if (this.stat == 3) {
            statpoints = PlayerCharacter.getMagic();
        }
        System.out.println("statpoints = " + statpoints);
        if (statpoints < 150) {
            unlocked = 1; // One attack unlocked
        } else if (statpoints < 200 && attacks[1] != null) {
            unlocked = 2; // Two attacks unlocked
        } else if (statpoints > 200 && attacks[2] != null) {
            if (!special) {
                unlocked = 3; // Three attacks unlocked
            } else {
                unlocked = 4; // Four attacks unlocked
            }
        }
    }

    public String getAttack(int ix, boolean layout) {
        String display;
        if (layout) {
            display = "           [" + (ix + 1) + "] ";
            if (unlocked < ix + 1) {
                display += "<...>";
            } else {
                display += attacks[ix] + " (" + NRGY[ix] + " NRGY)";
            }
            int spaces = 50 - display.length();
            for (int i = 0; i < spaces; i++) {
                display += " ";
            }
        } else {
            if (unlocked < ix + 1) {
                display = "<...>";
            } else {
                display = attacks[ix];
            }
        }
        return display;
    }

    public void addAudio(int ix){
        String path = "attacks/";
        switch(attacks[ix]){
            case "SHOOT":
            case "FIRE":
            case "BLAST":
                path += "bow.wav";
                break;
            case "BOMBARD":
                //path += "19_bombard.wav";
                break;
            case "CUT":
                path += "21_cut.wav";
                break;
            case "CHARGE":
                path += "22_charge.wav";
                break;
            case "SLICE":
                path += "23_slice.wav";
                break;
            case "ASSAULT":
                //path += "29_assault.wav";
                break;
            case "POKE":
                path += "31_poke.wav";
                break;
            case "STAB":
                path += "32_stab.wav";
                break;
            case "THRUST":
                path += "33_thrust.wav";
                break;
            case "PIERCE":
                path += "39_pierce.wav";
                break;
            case "PLOW":
                //path += "39_plow.wav";
                break;
            case "STRIKE":
                path += "41_strike.wav";
                break;
            case "BEAT":
                path += "42_beat.wav";
                break;
            case "SMITE":
                path += "43_smite.wav";
                break;
            case "CRUSH":
                path += "49_crush.wav";
                break;
            default:
                path = "";
        }
        audiofiles[ix] = path;
    }
}