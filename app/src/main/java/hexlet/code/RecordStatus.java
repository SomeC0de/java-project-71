package hexlet.code;

enum DiffStyle {
        STYLISH,
        PLAIN,
        JSON,
        DIFF_STYLE_MAX
}

public enum RecordStatus {
        NOT_CHANGED("unchanged"),
        CHANGED("changed"),
        REMOVED("deleted"),
        ADDED("added");

        private String state;

        RecordStatus(String state) {
                this.state = state;
        }

        public String getState() {
                return state;
        }
}
