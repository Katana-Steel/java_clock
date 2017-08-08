JAVA=javac


all:
	@echo "building clock.jar"
	@$(JAVA) ten_hour_clock.java
	@zip -9 clock.jar *.class META-INF META-INF/*


clean:
	rm -f *.class
