package com.eventlistener.event;



public class KisiEventCreater {
        private Object source;

        public KisiEventCreater(Object source) {
                this.source=source;
        }

        public Object getSource() {
                return source;
        }

        public void setSource(Object source) {
                this.source = source;
        }

        @Override
        public String toString() {
                return "KisiEventCreater{" +
                        "source=" + source +
                        '}';
        }
}
