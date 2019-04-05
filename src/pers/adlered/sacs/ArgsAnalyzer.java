package pers.adlered.sacs;

public class ArgsAnalyzer {
    public static void analyzeList(String args) {
        //Ignore space
        args = args.replaceAll(" ", "");
        //Split comma
        String[] comma = args.split(",");
        //Process dash
        System.out.println(args);
        for (String i : comma) {
            System.out.println("--- Analyzing " + i + " ---");
            String[] dash = i.split("-");
            if (dash.length > 2) {
                System.out.println(i + "!");
            }
            String dashPrefix = dash[0];
            String dashSuffix = dash[1];
            //Split comma in prefix
            String[] commaPrefix = dashPrefix.split("\\.");
            int rangeA = Integer.parseInt(commaPrefix[commaPrefix.length - 1]);
            //Split comma in suffix
            String[] commaSuffix = dashSuffix.split("\\.");
            int rangeB = Integer.parseInt(commaSuffix[0]);
            if (rangeA > rangeB) {
                int temp = rangeB;
                rangeB = rangeA;
                rangeA = temp;
            }
            System.out.println("Range is " + rangeA + "-" + rangeB);

            Definer.segment = segmentAnalyzer(commaPrefix);
            System.out.println("Checked segment is " + Definer.segment);
            addHosts(rangeA, rangeB, commaPrefix, commaSuffix);

            System.out.println("> Prefix");
            for (String cp : commaPrefix) {
                System.out.print(cp + " ");
            }
            System.out.println();
            System.out.println("> Suffix");
            for (String cs : commaSuffix) {
                System.out.print(cs + " ");
            }
            System.out.println();
        }
        System.out.println("=== Scanning for " + Definer.scanList.size() + " results ===");
        /*for (String scan : Definer.scanList) {
            System.out.print(scan + " ");
        }*/
        long ET = Definer.scanList.size() / Definer.threads * (Definer.timeout / 1000);
        System.out.println("Estimated time: " + new CountTimeBySec().CountBySec(ET));
        for (String scan : Definer.scanList) {
            Definer.executorService.execute(new Ping(scan));
        }
        System.out.println("=== Please wait ===");
    }

    public static String segmentAnalyzer(String[] prefix) {
        int prefixLength = prefix.length - 1;
        System.out.println("Prefix length is " + prefixLength);
        switch (prefixLength) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            default:
                return "C";
        }
    }

    public static void addHosts(int rangeA, int rangeB, String[] commaPrefix, String[] commaSuffix) {
        switch (Definer.segment) {
            case "A":
                for (int a = rangeA; a <= rangeB; a++) {
                    for (int i = 0; i < 255; i++) {
                        for (int j = 0; j < 255; j++) {
                            for (int k = 0; k < 255; k++) {
                                Definer.scanList.add(a + "." + i + "." + j + "." + k);
                            }
                        }
                    }
                }
                break;
            case "B":
                for (int a = rangeA; a <= rangeB; a++) {
                    for (int i = 0; i < 255; i++) {
                        for (int j = 0; j < 255; j++) {
                            Definer.scanList.add(commaPrefix[0] + "." + a + "." + i + "." + j);
                        }
                    }
                }
                break;
            case "C":
                for (int a = rangeA; a <= rangeB; a++) {
                    for (int i = 0; i < 255; i++) {
                        Definer.scanList.add(commaPrefix[0] + "." + commaPrefix[1] + "." + a + "." + i);
                    }
                }
                break;
            case "D":
                for (int a = rangeA; a <= rangeB; a++) {
                    Definer.scanList.add(commaPrefix[0] + "." + commaPrefix[1] + "." + commaPrefix[2] + "." + a);
                }
                break;
            default:
                for (int a = rangeA; a <= rangeB; a++) {
                    for (int i = 0; i < 255; i++) {
                        Definer.scanList.add(commaPrefix[0] + "." + commaPrefix[1] + "." + a + "." + i);
                    }
                }
        }
    }
}