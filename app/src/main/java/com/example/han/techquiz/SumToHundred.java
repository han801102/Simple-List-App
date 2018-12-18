package com.example.han.techquiz;

public class SumToHundred {

    private static final int DIGITS = 9;

    // First one only have one state
    int[] state = new int[DIGITS - 1];

    class State {
        private static final int PLUS = 0;
        private static final int MINUS = 1;
        private static final int CARRY = 2;
    }

    /* Every digits have three state: plus, minus, carry( combine with previous number )
     *  For example:
     *      1,     2,     3,     4      5
     *          plus, carry, carry, minus   => 1 + 234 - 5
     */
    public void start() {
        int carryPointer;

        /*
         * Present state array using 0, 1, 2
         * Then, plus one in every step from 00000000 to 22222222
         */
        while (state[DIGITS - 2] <= 2) {
            countAns();
            carryPointer = 0;
            state[carryPointer]++;

            // Carry
            while (state[carryPointer] > 2 && state[DIGITS - 2] <= 2) {
                state[carryPointer] = 0;
                state[++carryPointer]++;
            }
        }
    }

    private void countAns() {
        int prevNum = 1;
        int ans = 0;
        StringBuilder formula = new StringBuilder();
        // Store number until next plus or minus signj
        for (int i = 0; i < 8; i++) {
            switch (state[i]) {
                case State.PLUS:
                    appendNumber(formula, prevNum);
                    ans += prevNum;
                    prevNum = i + 2;
                    break;
                case State.MINUS:
                    appendNumber(formula, prevNum);
                    ans += prevNum;
                    prevNum = -(i + 2);
                    break;
                case State.CARRY:
                    if (prevNum > 0) {
                        prevNum = prevNum * 10 + i + 2;
                    } else {
                        prevNum = prevNum * 10 - (i + 2);
                    }

                    break;
            }
        }
        appendNumber(formula, prevNum);
        ans += prevNum;
        if (ans == 100) {
            System.out.println(formula.toString());
        }
    }

    private void appendNumber(StringBuilder stringBuilder, int number) {
        if (stringBuilder.toString().equals("")) {
            stringBuilder.append(number);
        } else if (number > 0) {
            stringBuilder.append(" + ").append(number);
        } else {
            stringBuilder.append(" - ").append(Math.abs(number));
        }
    }
}
