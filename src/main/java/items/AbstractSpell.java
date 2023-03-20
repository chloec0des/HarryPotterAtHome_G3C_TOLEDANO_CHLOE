package items;

public abstract class AbstractSpell {
    protected String name;
    protected int damage;
    protected int precision;
    protected int requiredMagicLevel;

    public AbstractSpell(String name, int damage, int precision, int requiredMagicLevel) {
        this.name = name;
        this.damage = damage;
        this.precision = precision;
        this.requiredMagicLevel = requiredMagicLevel;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getPrecision() {
        return precision;
    }

    public int getRequiredMagicLevel() {
        return requiredMagicLevel;
    }

    public abstract void cast(Character caster, Character target);
}

