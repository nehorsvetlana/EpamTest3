package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Data {
    public Long summary[];
    public String elements[];
    public String color;
    public String metals;
    public String vegetables[];
}
