---
title: Index
---

{% assign indexPages = site.pages | where: 'day', 0 | where_exp: 'page', 'page.year' | sort: 'year' -%}

{%- for idx in indexPages -%}
[{{idx.year}}]({{site.baseurl}}{{idx.url}})
{% assign yearPages = site.pages | where: 'year', idx.year | where_exp: 'page', 'page.day != 0' | sort: 'day' %}
{% for page in yearPages -%}
* [{{page.title}}]({{site.baseurl}}{{page.url}})

{% endfor -%}
{%- endfor -%}
