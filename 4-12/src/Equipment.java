public class Equipment implements Comparable<Equipment>, Cloneable {
    private String name;
    private int attackPower;
    private int defensePower;

    public Equipment(String name, int attackPower, int defensePower) {
        this.name = name;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public int getPower() {
        return (attackPower + defensePower);
    }

    @Override
    public Equipment clone()  {
        try {
            Equipment copy = (Equipment) super.clone();
            return copy;
        } catch(CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Equipment other = (Equipment) obj;
        return name.equals(other.name) && attackPower == other.attackPower && defensePower == other.defensePower;
    }

    @Override
    public int compareTo(Equipment other) {
        return Integer.compare(other.getPower(), this.getPower());
    }

    @Override
    public String toString() {
        return name + " (攻撃力:" + attackPower + " 防御力:" + defensePower + ")";
    }
}
