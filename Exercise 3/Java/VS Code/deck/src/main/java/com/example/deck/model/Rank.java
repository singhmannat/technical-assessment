public enum Rank {
    A("Ace"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"),
    SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
    J("Jack"), Q("Queen"), K("King");

    public final String label;
    Rank(String label) { this.label = label; }
}
