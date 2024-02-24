package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String textOfTag;
    private TagInterface tag;

    public LabelTag(String textOfTag, TagInterface tag) {
        this.textOfTag = textOfTag;
        this.tag = tag;
    }

    public String render() {
        return "<label>" + textOfTag + tag.render() + "</label>";
    }
 }
// END
