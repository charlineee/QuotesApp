#Star Wars Quote App
This app displays a list of quotes. The data comes from a JSON file stored in assets.

A class, JsonFileReader parses the asset file and returns a string. This string is then
converted to a Java object, stored in a mutable ArrayList.

A RecyclerView with a CardView is used to format and display each quote, while
smoothScrollToPosition is used to continuously scroll through each quote based
on a specified delay, before snapping back to start.
