package propMinimization;
/**
 * PROPOSITIONAL LOGIC – MINIMIZATION CALCULATOR
 * Minimal Normal Forms & Prime Implicants
 * Part of the TreeOfKnowledge.eu project.
 *
* 🕯 Dedicated to every unborn child lost to abortion — an estimated ~200 000 each day worldwide. (Based on WHO global estimates of ~73 million abortions per year.)
 *
 * Th© BEST CORE of AI
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

// © JAnica Tesla Zrinski – Original Source of Th© CORE of AI
public class Primjeri{
	
	public static String primjer0(){//tautologija
		return  " " + 
		Calc.NEGACIJA_CHAR + "(A" + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "B)" + Calc.POVLACI_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.OR_CHAR + "B)";

	}
	public static String primjer1(){//21 - moj Primjer 6.2. str.27
		return	
		" (A" + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "B)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + "B)" + Calc.OR_CHAR +
		"(B" + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "C)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + "C)";
	}
	public static String primjer2(){//25 - moj Primjer 8.1. str.33
		return	
		" (A" + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + "C)" + Calc.OR_CHAR + 
		 "(A" + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "C)" + Calc.OR_CHAR + 
		 "(A" + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + "C)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "C)";
	}
	public static String primjer3(){//33&4 - moj Primjer 8.2. odnosno 7.3. str.33 odn. 30
		return
		" (A" + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		"(A" + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "C)" + Calc.OR_CHAR + 
		"(A" + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)";
	}
	public static String primjer4(){// Solved Problems 4.25. - moj Primjer 9.1. str.40 - 3 minimal DNF's -> unique minimal CNF - FULL DNF
		return
		" (A" + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		"(A" + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + "D)";
	}
	/* public static String primjer4(){// Solved Problems 4.25. - moj Primjer 9.1. str.40 - 3 minimal DNF's -> unique minimal CNF - CNF!!
		return
		" (A" + Calc.OR_CHAR + 'B' + Calc.OR_CHAR + 'C' + Calc.OR_CHAR + "D)" + Calc.AND_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.OR_CHAR + Calc.NEGACIJA_CHAR + "B)" + Calc.AND_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.OR_CHAR + Calc.NEGACIJA_CHAR + "C)" + Calc.AND_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'B' + Calc.OR_CHAR + Calc.NEGACIJA_CHAR + "C)";
	} */
	public static String primjer5(){//26 - unique minimal DNF - FULL DNF!
		return
		" (A" + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		"(A" + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		"(A" + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)" + Calc.OR_CHAR + 
		"(A" + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + "D)";
	}
	/* public static String primjer5(){//26 - unique minimal DNF - PRIME IMPLICANTS
		return
		" (A" + Calc.AND_CHAR  + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		"(B" +  Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		"(A" + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "C)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + "C)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A'  + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + "D)";
	} */
	public static String primjer6(){// 27 - FULL DNF!
		return	
		" (A" + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		"(A" + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)" + Calc.OR_CHAR + 
		"(A" + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		"(A" + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)" + Calc.OR_CHAR + 
		"(A" + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		"(A" + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)" + Calc.OR_CHAR +
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)";
	}
	/* public static String primjer6(){// 27 - PRIME IMPLICANTS
		return	
		" (A" + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "B)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + "B)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'A' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)" + Calc.OR_CHAR + 
		'(' + Calc.NEGACIJA_CHAR + 'B' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + 'C' + Calc.AND_CHAR + Calc.NEGACIJA_CHAR + "D)" + Calc.OR_CHAR + 
		"(B" + Calc.AND_CHAR + "C)" + Calc.OR_CHAR + 
		"(B" + Calc.AND_CHAR + "C)";
	} */
}
