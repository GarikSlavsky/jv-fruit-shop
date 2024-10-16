package model;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String symbol, String fruit, int quantity) {
        this.operation = Operation.fromCode(symbol);
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String transaction;

        Operation(String symbol) {
            transaction = symbol;
        }

        public String getOperatingSymbol() {
            return transaction;
        }

        public static Operation fromCode(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.transaction.equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException(
                    "There is no Enum element, corresponding to the argument " + code);
        }
    }
}
