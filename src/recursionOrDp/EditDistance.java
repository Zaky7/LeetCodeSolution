package recursionOrDp;

class EditDistance {
  private static final int ROW = 2;

  public int minDistanceDp(String word1, String word2) {
    int R = word1.length();
    int C = word2.length();

    int[][] dp = new int[R + 1][C + 1];

    for (int i = 0; i <= R; i++) {
      dp[i][0] = i;
    }

    for (int j = 0; j <= C; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i <= R; i++) {
      for (int j = 1; j <= C; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] =
            1 +
            Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
        }
      }
    }

    return dp[R][C];
  }

  public int minDistanceDpMemoryOptimisedFake(String word1, String word2) {
    int R = word1.length();
    int C = word2.length();
    int[][] dp = new int[ROW][C + 1];

    for (int j = 0; j <= C; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i <= R; i++) {
      dp[computeRow(i)][0] = i;
      for (int j = 1; j <= C; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[computeRow(i)][j] = dp[computeRow(i - 1)][j - 1];
        } else {
          dp[computeRow(i)][j] =
            1 +
            Math.min(
              dp[computeRow(i - 1)][j - 1],
              Math.min(dp[computeRow(i - 1)][j], dp[computeRow(i)][j - 1])
            );
        }
      }
    }

    return dp[computeRow(R)][C];
  }

  public int computeRow(int n) {
    return n % (ROW);
  }

  public static void main(String[] args) {
    String word1 =
      "LillianaKilbackEmilioBauchBeatriceFadelMyrtieJacobiDDSErynGaylordNatTrantowZackeryWillDr.EldredO'ConnellAlejandraTorpMacyHesselDanStreichLorenaSchneiderDDSGusMedhurstMr.LacyChristiansenMrs.IsacMurazikMaryjaneJacobsonCierraKirlinHassieSteuberJustusSchillerDarleneBartolettiMateoAbernathyDarleneKlingMelvinaTrompEmilyCollierGerryFisherMrs.KristyCartwrightBertramBreitenbergAdelaHuelVinnieLangoshRahulRitchieAylinCollierJr.AndreMohrMissJabariSimonisAnabelEichmannIMakaylaEmardIIBraxtonProsaccoKieraAbbottStantonWelchJadenBlandaGraceToyNellieHillsKaleMarvinMicaelaCassinOttoMcLaughlinReeseReillyJimmieVolkmanMargarettVolkmanHillaryNaderKathleenYundtMissJaydaQuitzonMyraPfannerstillAddieO'KeefeEudoraMcDermottDomenicoMarksIVBlakeKuhicMs.YasminWilliamsonCristopherConsidineAndreaneGerlachMrs.SimErdmanVeldaTorpBuddyKuhicHillaryVonPatriciaBlickShanieKiehnAntoniaBrownMelvinaJohnsonMariettaBoganAliyahStarkIUnaRauFaeTorpNedHackettTrentonDibbertKoreyMacGyverEstefaniaBlickMissDejahHermanAndrewRunolfsdottirErikaPredovic";
    String word2 =
      "DelphaWymanJaydaRunteParisConroyBellaAltenwerthErinWunschSr.MaeganLynchMissOrvalMorissetteMrs.FriedrichRoweJennieBatzIIIAntoninaBergstromPaytonKohlerZanderDibbertElseHarveyDeshawnBeerAdellaTowneTerrellLabadieCollinHartmannBenniePadbergBryceConsidineClotildeSchowalterGabrielCormierBernadetteOlsonBrigitteSchillerBernhardSchmelerAmosUllrichJonathanBatzAlanisGreenfelderKiraHermistonIICaroleDanielRossFarrellBrookBartonGloriaPowlowskiTerryReingerKearaGoldnerAbdullahMarksHerminiaDoyleNikitaBergstromVickyWunschMosesConnellyNigelFlatleyIDr.NicolettePowlowskiRashadSmithCaitlynReillyIIMr.ShanyHermistonBereniceMcCulloughIICortezSimonisShawnDickinsonJuliusBoyerJamirBoyerGregReillyHenrySmithamElveraRodriguezSerenityKilbackAmiraFaheyIVGeorgiannaRusselKileyKuphalMr.RowlandKautzerKieranMurazikKatherineKrisKaleyMorarLorineBaileyIgnatiusSchmelerJoWindlerLibbieBinsDVMRosalindNicolasJadynZulaufJr.Mr.JannieWilliamsonMaeveCormierFletaCronaEdythReichelDr.JayceMertzDurwardGulgowskiShayneLemkeKentonStrackeDr.RusselJast";

    EditDistance ed = new EditDistance();

    // Program 1
    long startTime1 = System.nanoTime();
    int result1 = ed.minDistanceDp(word1, word2);
    long endTime1 = System.nanoTime();

    long duration1 = (endTime1 - startTime1) / 1000; //divide by 1000000 to get milliseconds.
    System.out.println(
      "For 1 is: " + result1 + " time: " + duration1 + " seconds"
    );

    // Program 2
    long startTime2 = System.nanoTime();
    int result2 = ed.minDistanceDpMemoryOptimisedFake(word1, word2);
    long endTime2 = System.nanoTime();

    long duration2 = (endTime2 - startTime2) / 1000; //divide by 1000000 to get milliseconds.
    System.out.println(
      "For 2 is: " + result2 + " time: " + duration2 + " seconds"
    );
  }
}
