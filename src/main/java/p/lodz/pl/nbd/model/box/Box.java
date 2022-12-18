package p.lodz.pl.nbd.model.box;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public abstract class Box {

    private double weight;

    private int length;

    private int width;

    private int height;

    public double getBoxCost() {
        return weight * getCostModifier();
    }

    public abstract double getCostModifier();
}
