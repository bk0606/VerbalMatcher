VerbalMatcher
=============

Class helps to create large and complex
regular expressions in a simple way
For example:
<code>
VerbalMatcher VmGreeting = new VerbalMatcher()
           .then("Hello")
           .or("Hi")
           .then(", ")
           .then("Petter")
           .maybe("!");
</code>

Returns pattern: "((Hello)|(Hi))(, )(Petter)(!)?"
