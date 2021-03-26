package yellow.game.resources.objects;

import java.util.Random;

public class Material {
    static int weaponattributes = 4;
    static String[] mat = new String[weaponattributes];
    static Random rd = new Random();

    static int matclass;
    static void setMatClass(int set){ matclass = set; }
    static int getMatClass(){ return matclass; }


    static int getLowestMatLength(){ return 3; }
    static int getLowMatLength(){ return 4; }
    static int getMidMatLength(){ return 2; }
    static int getHighMatLength(){ return 3; }
    static int getHighestMatLength(){ return 4; }

    //0 = matname; 1 = weight; 2 = magicmultiplier; 3 = damagemultiplier



    static void setMaterial(int position){
        //0 = matname; 1 = weight; 2 = magicmultiplier; 3 = damagemultiplier
        String[][] materialselection = selectPool(getMatClass());
        for(int i = 0; i < weaponattributes; i++){
            mat[i] = materialselection[position][i];
        }
    }

    public Material(int level){
        double lowestmatpool; double lowmatpool; double midmatpool; double highmatpool; double highestmatpool = 1.0;
        //Determine probability of material by level
        if(level < 5){
            lowestmatpool = 0.7;
            lowmatpool = 0.9;
            midmatpool = 0.97;
            highmatpool = 0.995;
        }else if(level < 10){
            lowestmatpool = 0.4;
            lowmatpool = 0.7;
            midmatpool = 0.85;
            highmatpool = 0.97;
        }else if(level < 20){
            lowestmatpool = 0.1;
            lowmatpool = 0.4;
            midmatpool = 0.77;
            highmatpool = 0.97;
        }else {
            lowestmatpool = 0.1;
            lowmatpool = 0.4;
            midmatpool = 0.7;
            highmatpool = 0.95;
        }
        //Get a random material
        double percent = rd.nextDouble();

        if(percent <= lowestmatpool){
            setMatClass(0);
            setMaterial(rd.nextInt(getLowestMatLength() - 1));
        } else if(percent <= lowmatpool){
            setMatClass(1);
            setMaterial(rd.nextInt(getLowMatLength() - 1));
        } else if(percent <= midmatpool){
            setMatClass(2);
            setMaterial(rd.nextInt(getMidMatLength() - 1));
        } else if(percent <= highmatpool){
            setMatClass(3);
            setMaterial(rd.nextInt(getHighMatLength() - 1));
        } else {
            setMatClass(4);
            setMaterial(rd.nextInt(getHighestMatLength() - 1));
        }
    }

    static String[][] selectPool(int materialpool){
        //0 = matname; 1 = weight; 2 = magicmultiplier; 3 = damagemultiplier
        String[][] lowestmat = new String[getLowestMatLength()][weaponattributes];
        for(int i = 0; i < getLowestMatLength(); i++){
            for(int j = 2; j < weaponattributes; j++){
                lowestmat[i][j] = "0.0";
            } }
        lowestmat[0][0] = "WOODEN";
        lowestmat[0][1] = "3"; //weight
        lowestmat[1][0] = "BONE";
        lowestmat[1][1] = "2"; //weight
        lowestmat[2][0] = "STONE";
        lowestmat[2][1] = "15"; //weight

        String[][] lowmat = new String[getLowMatLength()][weaponattributes];
        for(int i = 0; i < getLowMatLength(); i++){
            for(int j = 2; j < weaponattributes; j++){
                lowmat[i][j] = "0.0";
            } }
        lowmat[0][0] = "COPPER";
        lowmat[0][1] = "15"; //weight
        lowmat[1][0] = "IRON";
        lowmat[1][1] = "20"; //weight
        lowmat[2][0] = "STEEL";
        lowmat[2][1] = "15"; //weight
        lowmat[2][3] = "0.7"; //damagemultiplier
        lowmat[3][0] = "OBSIDIAN";
        lowmat[3][1] = "15"; //weight
        lowmat[3][2] = "0.6"; //magicmultiplier
        lowmat[3][3] = "0.6"; //damagemultiplier

        String[][] midmat = new String[getMidMatLength()][weaponattributes];
        midmat[0][0] = "BRONZE";
        midmat[0][1] = "30"; //weight
        midmat[0][2] = "0.5"; //magicmultiplier
        midmat[0][3] = "0.9"; //damagemultiplier
        midmat[1][0] = "SILVER";
        midmat[1][1] = "30"; //weight
        midmat[1][2] = "0.9"; //magimultiplier
        midmat[1][3] = "0.9"; //damagemultiplier

        String[][] highmat = new String[getHighMatLength()][weaponattributes];
        highmat[0][0] = "GOLDEN";
        highmat[0][1] = "35"; //weight
        highmat[0][2] = "1.2"; //magicmultiplier
        highmat[0][3] = "1.2"; //damagemultiplier
        highmat[1][0] = "PLATINUM";
        highmat[1][1] = "20"; //weight
        highmat[1][2] = "1.6"; //magicmultiplier
        highmat[1][3] = "1.6"; //damagemultiplier
        highmat[2][0] = "TITANIUM";
        highmat[2][1] = "30"; //weight
        highmat[2][2] = "1.55"; //magicmultiplier
        highmat[2][3] = "1.8"; //damagemultiplier

        String[][] highestmat = new String[getHighestMatLength()][weaponattributes];
        highestmat[0][0] = "ADAMANTITE";
        highestmat[0][1] = "60"; //weight
        highestmat[0][2] = "2.3"; //magicmultiplier
        highestmat[0][3] = "2.4"; //damagemultiplier
        highestmat[1][0] = "COBALT";
        highestmat[1][1] = "60"; //weight
        highestmat[1][2] = "2.3"; //magicmultiplier
        highestmat[1][3] = "2.2"; //damagemultiplier
        highestmat[2][0] = "PALLADIUM";
        highestmat[2][1] = "50"; //weight
        highestmat[2][2] = "2.2"; //magicmultiplier
        highestmat[2][3] = "2.3"; //damagemultiplier
        highestmat[3][0] = "DRAGONBONE";
        highestmat[3][1] = "20"; //weight
        highestmat[3][2] = "2.4"; //magicmultiplier
        highestmat[3][3] = "2.3"; //damagemultiplier

        if(materialpool == 4){
            return highestmat;
        } else if(materialpool == 3){
            return highmat;
        } else if(materialpool == 2){
            return midmat;
        } else if(materialpool == 1){
            return lowmat;
        } else {
            return lowestmat;
        }
    }

}
