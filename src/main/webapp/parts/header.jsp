<header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary ps-3">
		<a href="<%=request.getContextPath()%>/list" class="navbar-brand">Archivio Studenti</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
		
		
			<ul class="navbar-nav mr-auto">
				<li class="nav-item ${!requestScope['javax.servlet.forward.request_uri'].contains('department') ? 'active' : ''}"><a class="nav-link"
					href="<%=request.getContextPath()%>/student">Studenti</a></li>

				<li class="nav-item ${requestScope['javax.servlet.forward.request_uri'].contains('department') ? 'active' : ''}"><a class="nav-link"
					href="<%=request.getContextPath()%>/department">Dipartimenti</a></li>
			</ul>
		</div>
	</nav>
</header>