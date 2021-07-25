package com.eventlistener.event;



public class AdresEventCreater {
        private Object source;

        public AdresEventCreater(Object source) {
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
                return "AdresEventCreater{" +
                        "source=" + source +
                        '}';
        }
}
