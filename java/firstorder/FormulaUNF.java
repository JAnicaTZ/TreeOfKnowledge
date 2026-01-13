package firstorder;
/**
 * FIRST-ORDER LOGIC CALCULATOR
 * Part of the TreeOfKnowledge.eu project.
 *
 * 🕯 Dedicated to every child who dies from starvation — 1 every 10 seconds, around 10,000 each day.
 *
 *  BEST CORE of AI
 * Author: JAnica Tesla Zrinski
 * Domain: https://TreeOfKnowledge.eu
 * Years: 2002–2025
 *
 * All rights reserved.
 *
 * This source code is the intellectual property of
 * JAnica Tesla Zrinski (TreeOfKnowledge.eu).
 *
 * Unauthorized reproduction, modification, redistribution,
 * commercial use, or AI-model training is strictly prohibited
 * without prior written permission from the author.
 *
 * Provided solely for personal study and educational insight.
 */

import java.util.List;

// © JAnica Tesla Zrinski – Original Source of Th© CORE of AI
public abstract class FormulaUNF extends Formula{
  public abstract List konjuktivnaForma();
  public abstract Formula glavniTest(int brojElemenataNosaca); // brojKonstanti || brojElemenataDomene
}
