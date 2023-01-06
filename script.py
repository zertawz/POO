from math import ceil

def center(msg):
	totallen = 60;

	rightlen = totallen//2 - len(msg) // 2;
	leftlen = totallen//2 - ceil(len(msg) / 2);
	print('//' +'=' * rightlen, msg, '=' * leftlen);

center("Attributes");
center("Constructors");
center("Getters / Setters");
center("Overrides");
center("Other methods");
