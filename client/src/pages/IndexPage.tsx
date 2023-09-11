import PageLayout from 'layouts/common/PageLayout';
import IndexPageLayout from 'layouts/page/IndexPageLayout';
import React from 'react';

function IndexPage() {
	return (
		<PageLayout>
			<IndexPageLayout
				RecommandArticles={
					<div style={{ height: '160vh' }}>
						<h1>Jeonny-BoilerPlate</h1>
						<h2>use react + typescript + prettier + ESLint + axios + react-router-dom</h2>
						<a href="https://github.com/" target="_blank" rel="noreferrer">
							GitHub
						</a>
						<br />
						<a href="https://jeon-ny.tistory.com/" target="_blank" rel="noreferrer">
							Tistory Dev Blog
						</a>
					</div>
				}
			/>
		</PageLayout>
	);
}

export default IndexPage;
