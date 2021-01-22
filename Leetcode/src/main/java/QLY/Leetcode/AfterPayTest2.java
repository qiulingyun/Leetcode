package QLY.Leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * AfterPay coding 2020年12月11日10:07:17
 *
 * Caution !!! Collection.containsAll 方法并不是当前集合是否包含子集，而是当前集合是否包含目标集合的元素，不论个数！！！
 */
public class AfterPayTest2 {
    private enum TokenValue {
        BLUE, BLACK, GREEN
    }
    private static class Token{
        public TokenValue value;

        public Token(TokenValue value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Token token = (Token) o;
            return value == token.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    private List<Token> wallet;

    public AfterPayTest2() {
        wallet = new ArrayList(Arrays.asList(new Token[]{ new Token(TokenValue.BLUE), new Token(TokenValue.BLACK), new Token(TokenValue.BLUE)}));
    }

    private static class Card{
        public List<Token> cost;

        public Card(List<Token> cost) {
            this.cost = cost;
        }
    }

    public boolean canPurchase(Card card){
        return wallet.containsAll(card.cost);
//        return wallet.containsAll(card.cost);
    }

    public static void main(String[] args) {
        AfterPayTest2 afterPayTest2 = new AfterPayTest2();

        Card card = new Card(Arrays.asList(new Token[]{new Token(TokenValue.BLACK), new Token(TokenValue.BLACK)}));
        System.out.println(afterPayTest2.canPurchase(card));

        System.out.println("EnumSet no =================================================");

//        EnumSet<TokenValue> wallets = EnumSet.of(TokenValue.BLUE, TokenValue.BLUE, TokenValue.GREEN);
//        EnumSet<TokenValue> cards = EnumSet.of(TokenValue.BLUE, TokenValue.GREEN, TokenValue.GREEN);
//        System.out.println("EnumSet contains:" + wallets.containsAll(cards));

        System.out.println("List no=================================================");
//        List<TokenValue> wallet = Arrays.asList(TokenValue.BLUE, TokenValue.BLUE, TokenValue.GREEN);
//        List<TokenValue> cards = Arrays.asList(TokenValue.BLUE, TokenValue.GREEN,  TokenValue.GREEN);
//        System.out.println("List containsAll:" + wallet.containsAll(cards));
//        System.out.println("List retainAll:" + wallet.retainAll(cards));

        System.out.println("List no=================================================");
        SortedMap<TokenValue, Integer> wallet = new TreeMap<>();
    }
}
