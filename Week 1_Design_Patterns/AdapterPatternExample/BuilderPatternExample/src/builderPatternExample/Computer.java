package builderPatternExample;

public class Computer {
	  private String CPU;
	    private String RAM;
	    private String storage;
	    private String GPU;
	    private String motherboard;

	    // Private constructor to enforce the use of the Builder
	    private Computer(Builder builder) {
	        this.CPU = builder.CPU;
	        this.RAM = builder.RAM;
	        this.storage = builder.storage;
	        this.GPU = builder.GPU;
	        this.motherboard = builder.motherboard;
	    }

	    // Getters (optional, for testing purposes)
	    public String getCPU() {
	        return CPU;
	    }

	    public String getRAM() {
	        return RAM;
	    }

	    public String getStorage() {
	        return storage;
	    }

	    public String getGPU() {
	        return GPU;
	    }

	    public String getMotherboard() {
	        return motherboard;
	    }

	    @Override
	    public String toString() {
	        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + 
	               ", GPU=" + GPU + ", motherboard=" + motherboard + "]";
	    }

	    // Static nested Builder class
	    public static class Builder {
	        private String CPU;
	        private String RAM;
	        private String storage;
	        private String GPU;
	        private String motherboard;

	        // Methods to set each attribute
	        public Builder setCPU(String CPU) {
	            this.CPU = CPU;
	            return this;
	        }

	        public Builder setRAM(String RAM) {
	            this.RAM = RAM;
	            return this;
	        }

	        public Builder setStorage(String storage) {
	            this.storage = storage;
	            return this;
	        }

	        public Builder setGPU(String GPU) {
	            this.GPU = GPU;
	            return this;
	        }

	        public Builder setMotherboard(String motherboard) {
	            this.motherboard = motherboard;
	            return this;
	        }

	        // Build method to return an instance of Computer
	        public Computer build() {
	            return new Computer(this);
	        }
	    }

}
