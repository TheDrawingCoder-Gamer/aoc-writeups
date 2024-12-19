---
title: 2024 Writeups
year: 2024
day: 0
---

{% assign writeup2024 = site.pages | where: 'year', 2024 | where_exp: "page", "page.day != 0" | sort: "day" %}

{% for page in writeup2024 %}
  [{{page.title}}]({{site.baseurl}}{{page.url}})

{% endfor %}
