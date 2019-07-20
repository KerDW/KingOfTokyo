/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Álvaro
 */
public class M_cardStack {

    private ArrayList<M_Pcard> cardStack;
    private ArrayList<M_Pcard> codedCardStack;

    public M_cardStack() {
        this.cardStack = new ArrayList<>();
        this.codedCardStack = new ArrayList<>();
        codedCards();
    }

    public ArrayList<M_Pcard> getCardStack() {
        return cardStack;
    }

    public void setCardStack(ArrayList<M_Pcard> cardStack) {
        this.cardStack = cardStack;
    }

    public ArrayList<M_Pcard> getCodedCardStack() {
        return codedCardStack;
    }

    public void setCodedCardStack(ArrayList<M_Pcard> codedCardStack) {
        this.codedCardStack = codedCardStack;
    }

    public void allCards() {
        // M_Pcard acidAttack = new M_Pcard(0,6,"Acid Attack","Keep","Deal 1 extra damage each turn (even when you don't otherwise attack)."); < modelo
        // 0 0 0 WPCHANGE HPCHANGE ENRGCHANGE
        
        M_Pcard acidA = new M_Pcard(0,6,"Acid Attack","Keep","Deal 1 extra damage each turn (even when you don't otherwise attack)."); cardStack.add(acidA);
        M_Pcard alienM = new M_Pcard(1,3,"Alien Metabolism","Keep","Buying cards costs you 1 less  energia."); cardStack.add(alienM);
        M_Pcard alphaM = new M_Pcard(2,5,"Alpha Monster","Keep","Gain 1 Ptos victoria when you attack."); cardStack.add(alphaM);
        M_Pcard apartB = new M_Pcard(3,5,"Apartment Building","Discard","+ 3 Ptos victoria"); cardStack.add(apartB);
        M_Pcard armorP = new M_Pcard(4,4,"Armor Plating","Keep","Ignore damage of 1."); cardStack.add(armorP);
        M_Pcard bgD = new M_Pcard(5,4,"Background Dweller","Keep","You can always reroll any [3] you have."); cardStack.add(bgD);
        M_Pcard burrow = new M_Pcard(6,5,"Burrowing","Keep","Deal 1 extra damage on Tokyo. Deal 1 damage when yielding Tokyo to the monster taking it."); cardStack.add(burrow);
        M_Pcard camo = new M_Pcard(7,3,"Camouflage","Keep","If you take damage roll a die for each damage point. On a [Heart] you do not take that damage point."); cardStack.add(camo);
        // hasta aquí he seguido el orden de la web, a partir de ahora haré las cartas tipo Discard solo, mas adelante volveré a por las Keep
        M_Pcard comT = new M_Pcard(8,4,"Commuter Train","Discard","+ 2 Ptos victoria",2,0,0); cardStack.add(comT);
        M_Pcard cornerS = new M_Pcard(9,3,"Corner Store","Discard","+ 1 Ptos victoria",1,0,0); cardStack.add(cornerS);
        M_Pcard drop = new M_Pcard(10,5,"Drop from High Altitude","Discard","+ 2 Ptos victoria and take control of Tokyo if you don't already control it.",2,0,0); cardStack.add(drop);
        M_Pcard enrgize = new M_Pcard(11,8,"Energize","Discard","+ 9 energia"); cardStack.add(enrgize);
        M_Pcard evac = new M_Pcard(12,7,"Evacuation Orders","Discard","All other monsters lose 5 Ptos victoria."); cardStack.add(evac); cardStack.add(evac); // x2 
        M_Pcard fireB = new M_Pcard(13,3,"Fire Blast","Discard","Deal 2 damage to all other monsters."); cardStack.add(fireB);
        M_Pcard frenzy = new M_Pcard(14,7,"Frenzy","Discard","When you purchase this card Take another turn immediately after this one."); cardStack.add(frenzy);
        M_Pcard gasR = new M_Pcard(15,6,"Gas Refinery","Discard","+ 2 Ptos victoria and deal 3 damage to all other monsters."); cardStack.add(gasR);
        M_Pcard heal = new M_Pcard(16,3,"Heal","Discard","Heal 2 damage."); cardStack.add(heal);
        M_Pcard hab = new M_Pcard(17,4,"High Altitude Bombing","Discard","All monsters (including you) take 3 damage."); cardStack.add(hab);
        M_Pcard jetF = new M_Pcard(18,5,"Jet Fighters","Discard","+ 5 Ptos victoria and take 4 damage"); cardStack.add(jetF);
        M_Pcard natG = new M_Pcard(19,3,"National Guard","Discard","+ 2 Ptos victoria and take 2 damage."); cardStack.add(natG);
        M_Pcard npp = new M_Pcard(20,6,"Nuclear Power Plant","Discard","+ 2 Ptos victoria and heal 3 damage."); cardStack.add(npp);
        M_Pcard skys = new M_Pcard(21,6,"Skyscraper","Discard","+ 4 Ptos victoria"); cardStack.add(skys);
        M_Pcard tanks = new M_Pcard(22,4,"Tanks","Discard","+ 4 Ptos victoria and take 3 damage."); cardStack.add(tanks);
        M_Pcard vastS = new M_Pcard(23,6,"Vast Storm","Discard","+ 2 Ptos victoria. All other monsters lose 1 energia for every 2 energia they have."); cardStack.add(vastS);
        M_Pcard amusP = new M_Pcard(24,6,"Amusement Park","Discard","+ 4 Ptos victoria"); cardStack.add(amusP);
        M_Pcard army = new M_Pcard(25,2,"Army","Discard","(+ 1 Ptos victoria and suffer one damage) for each card you have."); cardStack.add(army);
        // tipo Discard acabado, sigo con Keep
        M_Pcard compD = new M_Pcard(26,3,"Complete Destruction","Keep","If you roll [1][2][3][Heart][Attack] energia gain 9 Ptos victoria in addition to the regular results."); cardStack.add(compD);
        M_Pcard dnt = new M_Pcard(27,3,"Dedicated News Team","Keep","Gain 1 Ptos victoria whenever you buy a card."); cardStack.add(dnt);
        M_Pcard eotd = new M_Pcard(28,4,"Eater of the Dead","Keep","Gain 3 Ptos victoria every time a monster's [Heart] goes to 0."); cardStack.add(eotd);
        M_Pcard enrgh = new M_Pcard(29,3,"Energy Hoarder","Keep","You gain 1 Ptos victoria for every 6 energia you have at the end of your turn."); cardStack.add(enrgh);
        M_Pcard evenB = new M_Pcard(30,4,"Even Bigger","Keep","Your maximum [Heart] is increased by 2. Gain 2[Heart] when you get this card."); cardStack.add(evenB); // hay que hacer exepciones en cardbought y en draindies
        M_Pcard extraH = new M_Pcard(31,7,"Extra Head","Keep","You get 1 extra die."); cardStack.add(extraH); cardStack.add(extraH); // x2
        M_Pcard fireBr = new M_Pcard(32,4,"Fire Breathing","Keep","Your neighbors take 1 extra damage when you deal damage."); cardStack.add(fireBr);
        M_Pcard freezeT = new M_Pcard(33,5,"Freeze Time","Keep","On a turn where you score [1][1][1], you can take another turn with one less die."); cardStack.add(freezeT);
        M_Pcard foc = new M_Pcard(34,4,"Friend of Children","Keep","When you gain any  energia gain 1 extra  energia."); cardStack.add(foc);
        M_Pcard giantB = new M_Pcard(35,5,"Giant Brain","Keep","You have one extra reroll each turn."); cardStack.add(giantB);
        M_Pcard gourmet = new M_Pcard(36,4,"Gourmet","Keep","When scoring [1][1][1] gain 2 extra Ptos victoria."); cardStack.add(gourmet);
        M_Pcard healingR = new M_Pcard(37,4,"Extra Head","Keep","You can heal other monsters with your [Heart] results. They must pay you 2 energia for each damage you heal (or their remaining  energia if they haven't got enough."); cardStack.add(healingR);
        M_Pcard herbivore = new M_Pcard(38,5,"Herbivore","Keep","If you roll [1][2][3][Heart][Attack] energia gain 9 Ptos victoria in addition to the regular results."); cardStack.add(herbivore);
        M_Pcard herdC = new M_Pcard(39,3,"Herd Culler","Keep","You can change one of your dice to a [1] each turn."); cardStack.add(herdC);
        M_Pcard ihac = new M_Pcard(40,7,"It Has a Child","Keep","If you are eliminated discard all your cards and lose all your  Ptos victoria, Heal to 10[Heart] and start again."); cardStack.add(ihac);
        M_Pcard jets = new M_Pcard(41,5,"Jets","Keep","You suffer no damage when yielding Tokyo."); cardStack.add(jets);
        M_Pcard mial = new M_Pcard(42,2,"Made in a Lab","Keep","When purchasing cards you can peek at and purchase the top card of the deck."); cardStack.add(mial);
        M_Pcard metam = new M_Pcard(43,3,"Metamorph","Keep","At the end of your turn you can discard any keep cards you have to receive the  energia they were purchased for."); cardStack.add(metam);
        M_Pcard mimic = new M_Pcard(44,8,"Mimic","Keep","Choose a card any monster has in play and put a mimic counter on it. This card counts as a duplicate of that card as if it just had been bought. Spend 1 energia at the start of your turn to change the power you are mimicking."); cardStack.add(mimic);
        M_Pcard monsterB = new M_Pcard(45,2,"Monster Batteries","Keep","When you purchase this put as many  energia as you want on it from your reserve. Match this from the bank. At the start of each turn take 2 energia off and add them to your reserve. When there are no  energia left discard this card."); cardStack.add(monsterB);
        M_Pcard novaB = new M_Pcard(46,7,"Nova Breath","Keep","Your attacks damage all other monsters."); cardStack.add(novaB);
        M_Pcard omnivore = new M_Pcard(47,4,"Omnivore","Keep","Once each turn you can score [1][2][3] for 2 Ptos victoria. You can use these dice in other combinations."); cardStack.add(omnivore);
        M_Pcard opportunist = new M_Pcard(48,3,"Opportunist","Keep","Whenever a new card is revealed you have the option of purchasing it as soon as it is revealed."); cardStack.add(opportunist);
        M_Pcard parasT = new M_Pcard(49,4,"Parasitic Tentacles","Keep","You can purchase cards from other monsters. Pay them the  energia cost."); cardStack.add(parasT);
        M_Pcard plotT = new M_Pcard(50,3,"Plot Twist","Keep","Change one die to any result. Discard when used."); cardStack.add(plotT);
        M_Pcard poisonQ = new M_Pcard(51,3,"Poison Quills","Keep","When you score [2][2][2] also deal 2 damage."); cardStack.add(poisonQ);
        M_Pcard poisonS = new M_Pcard(52,4,"Poison Spit","Keep","When you deal damage to monsters give them a poison counter. Monsters take 1 damage for each poison counter they have at the end of their turn. You can get rid of a poison counter with a [Heart] (that [Heart] doesn't heal a damage also)."); cardStack.add(poisonS);
        M_Pcard psyP = new M_Pcard(53,3,"Psychic Probe","Keep","You can reroll a die of each other monster once each turn. If the reroll is [Heart] discard this card."); cardStack.add(psyP);
        M_Pcard rapidH = new M_Pcard(54,3,"Rapid Healing","Keep","Spend 2 energia at any time to heal 1 damage."); cardStack.add(rapidH);
        M_Pcard regen = new M_Pcard(55,4,"Regeneration","Keep","When you heal, heal 1 extra damage."); cardStack.add(regen);
        M_Pcard rftud = new M_Pcard(56,3,"Rooting for the underdog","Keep","At the end of a turn when you have the fewest  Ptos victoria gain 1  Ptos victoria."); cardStack.add(rftud);
        M_Pcard shrinkR = new M_Pcard(57,6,"Shrink Ray","Keep","When you deal damage to monsters give them a shrink counter. A monster rolls one less die for each shrink counter. You can get rid of a shrink counter with a [Heart] (that [Heart] doesn't heal a damage also)."); cardStack.add(shrinkR);
        M_Pcard smokeC = new M_Pcard(58,4,"Smoke Cloud","Keep","This card starts with 3 charges. Spend a charge for an extra reroll. Discard this card when all charges are spent."); cardStack.add(smokeC);
        M_Pcard solarP = new M_Pcard(60,2,"Solar Powered","Keep","At the end of your turn gain 1 energia if you have no  energia."); cardStack.add(solarP);
        M_Pcard spikedT = new M_Pcard(61,5,"Spiked Tail","Keep","When you attack deal 1 extra damage."); cardStack.add(spikedT);
        M_Pcard stretchy = new M_Pcard(62,3,"Stretchy","Keep","You can spend 2 energia to change one of your dice to any result."); cardStack.add(stretchy);
        M_Pcard teleP = new M_Pcard(63,4,"Telepath","Keep","Spend 1 energia to get 1 extra reroll."); cardStack.add(teleP);
        M_Pcard urbavore = new M_Pcard(64,4,"Urbavore","Keep","Gain 1 extra  Ptos victoria when beginning the turn in Tokyo. Deal 1 extra damage when dealing any damage from Tokyo."); cardStack.add(urbavore);
        M_Pcard womis = new M_Pcard(65,3,"We're Only Making It Stronger","Keep","When you lose 2[Heart] or more gain 1 energia."); cardStack.add(womis);
        M_Pcard wings = new M_Pcard(66,6,"Wings","Keep","Spend 2 energia to negate damage to you for a turn."); cardStack.add(wings);
        M_Pcard cann = new M_Pcard(67,5,"Cannibalistic","Keep","When you do damage gain 1[Heart]."); cardStack.add(cann); //heals even in tokyo
        M_Pcard intR = new M_Pcard(68,3,"Intimidating Roar","Keep","The monsters in Tokyo must yield if you damage them."); cardStack.add(intR);
        M_Pcard monsterS = new M_Pcard(69,4,"Monster Sidekick","Keep","If someone kills you, Go back to 10[Heart] and lose all your Ptos victoria. If either of you or your killer win, or all other players are eliminated then you both win. If your killer is eliminated then you are also. If you are eliminated a second time this card has no effect."); cardStack.add(monsterS);
        M_Pcard reflectH = new M_Pcard(70,6,"Reflective Hide","Keep","If you suffer damage the monster that inflicted the damage suffers 1 as well."); cardStack.add(reflectH);
        M_Pcard sleepW = new M_Pcard(71,3,"Sleep Walker","Keep","Spend 3 energia to gain 1 Ptos victoria."); cardStack.add(sleepW);
        M_Pcard superJ = new M_Pcard(72,4,"Super Jump","Keep","Once each turn you may spend 1 energia to negate 1 damage you are receiving."); cardStack.add(superJ);
        M_Pcard tat = new M_Pcard(73,4,"Throw a Tanker","Keep","On a turn you deal 3 or more damage gain 2 Ptos victoria."); cardStack.add(tat);
        M_Pcard thunderS = new M_Pcard(74,3,"Thunder Stomp","Keep","If you score 4 Ptos victoria in a turn, all players roll one less die until your next turn."); cardStack.add(thunderS);
        M_Pcard unstableDNA = new M_Pcard(75,3,"Unstable DNA","Keep","If you yield Tokyo you can take any card the recipient has and give him this card."); cardStack.add(unstableDNA);
    }
    // las cartas q haya codeado las metere en otro array q se usará en el juego
    public void codedCards(){
        // 0 0 0 WPCHANGE HPCHANGE ENRGCHANGE
        
        M_Pcard apartB = new M_Pcard(3,5,"Apartment Building","Discard","+ 3 victory points",3,0,0); codedCardStack.add(apartB); //done
        M_Pcard comT = new M_Pcard(8,4,"Commuter Train","Discard","+ 2 victory points", 2, 0, 0); codedCardStack.add(comT); //done
        M_Pcard cornerS = new M_Pcard(9,3,"Corner Store","Discard","+ 1 victory points", 1, 0, 0); codedCardStack.add(cornerS); //done
        M_Pcard drop = new M_Pcard(10,5,"Drop from High Altitude","Discard","+ 2 victory points and take control of Tokyo City if you don't already control it.", 2, 0, 0); codedCardStack.add(drop); //done
        M_Pcard enrgize = new M_Pcard(11,8,"Energize","Discard","+ 9 energy",0,0,9); codedCardStack.add(enrgize); //done 
        M_Pcard evac = new M_Pcard(12,7,"Evacuation Orders","Discard","All other monsters lose 5 victory points."); codedCardStack.add(evac); codedCardStack.add(evac); // x2 done
        M_Pcard fireB = new M_Pcard(13,3,"Fire Blast","Discard","Deal 2 damage to all other monsters."); codedCardStack.add(fireB); //done
        M_Pcard frenzy = new M_Pcard(14,7,"Frenzy","Discard","When you purchase this card Take another turn immediately after this one."); codedCardStack.add(frenzy); // done
        M_Pcard gasR = new M_Pcard(15,6,"Gas Refinery","Discard","+ 2 victory points and deal 3 damage to all other monsters.",2,0,0); codedCardStack.add(gasR); // done
        M_Pcard heal = new M_Pcard(16,3,"Heal","Discard","Heal 2 damage.",0,2,0); codedCardStack.add(heal); //done
        M_Pcard hab = new M_Pcard(17,4,"High Altitude Bombing","Discard","All monsters (including you) take 3 damage."); codedCardStack.add(hab); // done
        M_Pcard jetF = new M_Pcard(18,5,"Jet Fighters","Discard","+ 5 victory points and take 4 damage",5,-4,0); codedCardStack.add(jetF); //done
        M_Pcard natG = new M_Pcard(19,3,"National Guard","Discard","+ 2 victory points and take 2 damage.",2,-2,0); codedCardStack.add(natG); //done
        M_Pcard npp = new M_Pcard(20,6,"Nuclear Power Plant","Discard","+ 2 victory points and heal 3 damage.",2,3,0); codedCardStack.add(npp); //done
        M_Pcard skys = new M_Pcard(21,6,"Skyscraper","Discard","+ 4 victory points",4,0,0); codedCardStack.add(skys); //done
        M_Pcard tanks = new M_Pcard(22,4,"Tanks","Discard","+ 4 victory points and take 3 damage.",4,-3,0); codedCardStack.add(tanks); //done
        M_Pcard vastS = new M_Pcard(23,6,"Vast Storm","Discard","+ 2 victory points. All other monsters lose 1 energy for every 2 energy they have.",2,0,0); codedCardStack.add(vastS); //done
        M_Pcard amusP = new M_Pcard(24,6,"Amusement Park","Discard","+ 4 victory points",4,0,0); codedCardStack.add(amusP); //done
        M_Pcard army = new M_Pcard(25,2,"Army","Discard","(+ 1 victory points and suffer one damage) for each card you have."); codedCardStack.add(army); //done
        // hasta aqui estan todas las cartas de discard, ahora empiezo con las de Keep
        M_Pcard acidA = new M_Pcard(0,6,"Acid Attack","Keep","Deal 1 extra damage each turn (even when you don't otherwise attack)."); codedCardStack.add(acidA); //done
        M_Pcard alienM = new M_Pcard(1,3,"Alien Metabolism","Keep","Buying cards costs you 1 less energy."); codedCardStack.add(alienM); //done
        M_Pcard alphaM = new M_Pcard(2,5,"Alpha Monster","Keep","Gain 1 victory points when you attack."); codedCardStack.add(alphaM); //done
        M_Pcard armorP = new M_Pcard(4,4,"Armor Plating","Keep","Ignore damage of 1."); codedCardStack.add(armorP); //done
        M_Pcard bgD = new M_Pcard(5,4,"Background Dweller","Keep","You can always reroll any [3] you have."); codedCardStack.add(bgD); //done 
        M_Pcard burrow = new M_Pcard(6,5,"Burrowing","Keep","Deal 1 extra damage when you are in Tokyo. Deal 1 damage when yielding Tokyo to the monster taking it."); codedCardStack.add(burrow); //done
        M_Pcard camo = new M_Pcard(7,3,"Camouflage","Keep","If you take damage roll a die for each damage point. On a [Heart] you do not take that damage point."); //esta la dejo, tiene pinta de ser muy dificil de implementar, mi idea es hacer un metodo para gestionar cada vez que un jugador sea dañado y ahi comprobar esto
        M_Pcard compD = new M_Pcard(26,3,"Complete Destruction","Keep","If you roll [1][2][3][Heart][Attack] energy gain 9 victory points in addition to the regular results."); codedCardStack.add(compD); //done
        M_Pcard dnt = new M_Pcard(27,3,"Dedicated News Team","Keep","Gain 1 victory points whenever you buy a card."); codedCardStack.add(dnt); //done
        M_Pcard eotd = new M_Pcard(28,4,"Eater of the Dead","Keep","Gain 3 victory points every time a monster's [Heart] goes to 0."); codedCardStack.add(eotd); //done
        M_Pcard enrgh = new M_Pcard(29,3,"Energy Hoarder","Keep","You gain 1 victory points for every 6 energy you have at the end of your turn."); codedCardStack.add(enrgh); //done
        M_Pcard evenB = new M_Pcard(30,4,"Even Bigger","Keep","Your maximum [Heart] is increased by 2. Gain 2[Heart] when you get this card."); // hay que hacer exepciones de vidas maximas en cardbought y en draindies
        M_Pcard extraH = new M_Pcard(31,7,"Extra Head","Keep","You get 1 extra die."); codedCardStack.add(extraH); codedCardStack.add(extraH); // x2 done
        M_Pcard fireBr = new M_Pcard(32,4,"Fire Breathing","Keep","Your neighbors take 1 extra damage when you deal damage to anyone."); //se hace daño via cartas, efectos de cartas y tiradas de dados, tambien en tokyo debido a efectos de cartas, lo ideal seria hacer un metodo para esta carta e ir aplicandolo
        M_Pcard freezeT = new M_Pcard(33,5,"Freeze Time","Keep","On a turn where you score [1][1][1], you can take another turn with one less die."); codedCardStack.add(freezeT); //done     
        // hasta aqui me faltan 3 cartas aun
        M_Pcard foc = new M_Pcard(34,4,"Friend of Children","Keep","When you gain any energy gain 1 extra energy.");
        M_Pcard giantB = new M_Pcard(35,5,"Giant Brain","Keep","You have one extra reroll each turn."); codedCardStack.add(giantB); //done
        M_Pcard gourmet = new M_Pcard(36,4,"Gourmet","Keep","When scoring [1][1][1] gain 2 extra victory points."); codedCardStack.add(gourmet); //done
        M_Pcard healingR = new M_Pcard(37,4,"Extra Head","Keep","You can heal other monsters with your [Heart] results. They must pay you 2 energy for each damage you heal (or their remaining energy if they haven't got enough.");
        M_Pcard herbivore = new M_Pcard(38,5,"Herbivore","Keep","Gain 1[Star] on your turn if you don't damage anyone.");
        M_Pcard herdC = new M_Pcard(39,3,"Herd Culler","Keep","You can change one of your dice to a [1] each turn.");
        M_Pcard ihac = new M_Pcard(40,7,"It Has a Child","Keep","If you are eliminated discard all your cards and lose all your victory points, Heal to 10[Heart] and start again."); 
        M_Pcard jets = new M_Pcard(41,5,"Jets","Keep","You suffer no damage when yielding Tokyo.");
        M_Pcard mial = new M_Pcard(42,2,"Made in a Lab","Keep","When purchasing cards you can peek at and purchase the top card of the deck."); cardStack.add(mial);
        M_Pcard metam = new M_Pcard(43,3,"Metamorph","Keep","At the end of your turn you can discard any keep cards you have to receive the energia they were purchased for."); cardStack.add(metam);
        M_Pcard mimic = new M_Pcard(44,8,"Mimic","Keep","Choose a card any monster has in play and put a mimic counter on it. This card counts as a duplicate of that card as if it just had been bought. Spend 1 energia at the start of your turn to change the power you are mimicking."); cardStack.add(mimic);
        M_Pcard monsterB = new M_Pcard(45,2,"Monster Batteries","Keep","When you purchase this put as many energia as you want on it from your reserve. Match this from the bank. At the start of each turn take 2 energia off and add them to your reserve. When there are no  energia left discard this card."); cardStack.add(monsterB);
        M_Pcard novaB = new M_Pcard(46,7,"Nova Breath","Keep","Your attacks damage all other monsters."); cardStack.add(novaB);
        M_Pcard omnivore = new M_Pcard(47,4,"Omnivore","Keep","Once each turn you can score [1][2][3] for 2 Ptos victoria. You can use these dice in other combinations."); codedCardStack.add(omnivore); //done
        M_Pcard opportunist = new M_Pcard(48,3,"Opportunist","Keep","Whenever a new card is revealed you have the option of purchasing it as soon as it is revealed."); cardStack.add(opportunist);
        M_Pcard parasT = new M_Pcard(49,4,"Parasitic Tentacles","Keep","You can purchase cards from other monsters. Pay them the  energia cost."); cardStack.add(parasT);
        M_Pcard plotT = new M_Pcard(50,3,"Plot Twist","Keep","Change one die to any result. Discard when used."); cardStack.add(plotT);
        M_Pcard poisonQ = new M_Pcard(51,3,"Poison Quills","Keep","When you score [2][2][2] also deal 2 damage."); codedCardStack.add(poisonQ); //done
        M_Pcard poisonS = new M_Pcard(52,4,"Poison Spit","Keep","When you deal damage to monsters give them a poison counter. Monsters take 1 damage for each poison counter they have at the end of their turn. You can get rid of a poison counter with a [Heart] (that [Heart] doesn't heal a damage also)."); cardStack.add(poisonS);
        M_Pcard psyP = new M_Pcard(53,3,"Psychic Probe","Keep","You can reroll a die of each other monster once each turn. If the reroll is [Heart] discard this card."); cardStack.add(psyP);
        M_Pcard rapidH = new M_Pcard(54,3,"Rapid Healing","Keep","Spend 2 energia at any time to heal 1 damage."); cardStack.add(rapidH);
        M_Pcard regen = new M_Pcard(55,4,"Regeneration","Keep","When you heal, heal 1 extra damage."); codedCardStack.add(regen); //done
        M_Pcard rftud = new M_Pcard(56,3,"Rooting for the underdog","Keep","At the end of a turn when you have the fewest  Ptos victoria gain 1  Ptos victoria."); cardStack.add(rftud);
        M_Pcard shrinkR = new M_Pcard(57,6,"Shrink Ray","Keep","When you deal damage to monsters give them a shrink counter. A monster rolls one less die for each shrink counter. You can get rid of a shrink counter with a [Heart] (that [Heart] doesn't heal a damage also)."); cardStack.add(shrinkR);
        M_Pcard smokeC = new M_Pcard(58,4,"Smoke Cloud","Keep","This card starts with 3 charges. Spend a charge for an extra reroll. Discard this card when all charges are spent."); cardStack.add(smokeC);
        M_Pcard solarP = new M_Pcard(60,2,"Solar Powered","Keep","At the end of your turn gain 1 energia if you have no  energia."); cardStack.add(solarP);
        M_Pcard spikedT = new M_Pcard(61,5,"Spiked Tail","Keep","When you attack deal 1 extra damage."); cardStack.add(spikedT);
        M_Pcard stretchy = new M_Pcard(62,3,"Stretchy","Keep","You can spend 2 energia to change one of your dice to any result."); cardStack.add(stretchy);
        M_Pcard teleP = new M_Pcard(63,4,"Telepath","Keep","Spend 1 energia to get 1 extra reroll."); cardStack.add(teleP);
        M_Pcard urbavore = new M_Pcard(64,4,"Urbavore","Keep","Gain 1 extra  Ptos victoria when beginning the turn in Tokyo. Deal 1 extra damage when dealing any damage from Tokyo."); cardStack.add(urbavore);
        M_Pcard womis = new M_Pcard(65,3,"We're Only Making It Stronger","Keep","When you lose 2[Heart] or more gain 1 energia."); cardStack.add(womis);
        M_Pcard wings = new M_Pcard(66,6,"Wings","Keep","Spend 2 energia to negate damage to you for a turn."); cardStack.add(wings);
        M_Pcard cann = new M_Pcard(67,5,"Cannibalistic","Keep","When you do damage gain 1[Heart]."); cardStack.add(cann); //heals even in tokyo
        M_Pcard intR = new M_Pcard(68,3,"Intimidating Roar","Keep","The monsters in Tokyo must yield if you damage them."); cardStack.add(intR);
        M_Pcard monsterS = new M_Pcard(69,4,"Monster Sidekick","Keep","If someone kills you, Go back to 10[Heart] and lose all your Ptos victoria. If either of you or your killer win, or all other players are eliminated then you both win. If your killer is eliminated then you are also. If you are eliminated a second time this card has no effect."); cardStack.add(monsterS);
        M_Pcard reflectH = new M_Pcard(70,6,"Reflective Hide","Keep","If you suffer damage the monster that inflicted the damage suffers 1 as well."); cardStack.add(reflectH);
        M_Pcard sleepW = new M_Pcard(71,3,"Sleep Walker","Keep","Spend 3 energia to gain 1 Ptos victoria."); cardStack.add(sleepW);
        M_Pcard superJ = new M_Pcard(72,4,"Super Jump","Keep","Once each turn you may spend 1 energia to negate 1 damage you are receiving."); cardStack.add(superJ);
        M_Pcard tat = new M_Pcard(73,4,"Throw a Tanker","Keep","On a turn you deal 3 or more damage gain 2 Ptos victoria."); //aplicado al daño de los dados, hace falta saber el daño total hecho en el turno x el jugador
        M_Pcard thunderS = new M_Pcard(74,3,"Thunder Stomp","Keep","If you score 4 Ptos victoria in a turn, all players roll one less die until your next turn."); cardStack.add(thunderS); //poner un boolean global que se cambie a true si la condicion se cumple y se cambie de nuevo a false al principio del turno del jugador q tiene la carta
        M_Pcard unstableDNA = new M_Pcard(75,3,"Unstable DNA","Keep","If you yield Tokyo you can take any card the recipient has and give him this card."); cardStack.add(unstableDNA);
        
    }
    
    public M_Pcard callRandom(){
        Random rand = new Random();
        return codedCardStack.get(rand.nextInt(codedCardStack.size()));
    }
    
    public void shuffle(){
        codedCards();
    }
    
}
