JAVA=javac


all:
	@echo "building clock.jar"
	@$(JAVA) ten_hour_clock.java clock_2d.java
	@jar cmf META-INF/MANIFEST.MF clock.jar *.class


clean:
	rm -f *.class
