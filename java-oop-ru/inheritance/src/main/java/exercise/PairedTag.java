package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String name;
    private Map<String, String> attr;
    private String tagBody;
    private List<Tag> subTag;

    public PairedTag(
            String name,
            Map<String, String> attr,
            String tagBody,
            List<Tag> subTag
    ) {
        super(name, attr);
        this.tagBody = tagBody;
        this.subTag = subTag;
    }

    @Override
    public String toString() {
        var result = new StringBuilder(super.toString());
        result.append(tagBody);

        for (Tag tag: subTag) {
            result.append(tag.toString());
        }
        result.append(String.format("</%s>", super.getName()));


        return result.toString();
    }

}
// END
