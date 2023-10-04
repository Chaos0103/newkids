import MyPageMenu from 'components/organisms/common/MyPageMenu';
import Pagination from 'components/organisms/common/Pagination';
import MyCollectionArticle from 'components/organisms/mycollection/MyCollectionArticle';
// import { DUMMY_ARTICLES } from 'constants/dummyreadarticle';
import PageLayout from 'layouts/common/PageLayout';
import MyCollectionLayout from 'layouts/page/MyCollectionLayout';
import React, { useEffect, useState } from 'react';
import { findAllReadArticleApi } from 'utils/apis/article';

function MyCollectionPage() {
	// 페이지네이션
	const [currentPage, setCurrentPage] = useState(1);
	const [totalPages, setTotalPages] = useState(3);
	const [size, setSize] = useState(8);
	const [currentGroup, setCurrentGroup] = useState(1);
	const [articles, setArticles] = useState([]);
	// const articles = DUMMY_ARTICLES;

	const searchPage = async () => {
		try {
			const memberkey = localStorage.getItem('memberkey');
			if (memberkey) {
				const response = await findAllReadArticleApi(memberkey, currentPage);
				console.log(response);
				if (response.status === 200) {
					setArticles(response.data.data.content);
					setTotalPages(response.data.data.totalPages);
					// setTotalPages(3);
					setSize(response.data.data.size);
				}
			}
		} catch (error) {
			console.log(error);
		}
	};

	useEffect(() => {
		searchPage();
	}, [currentPage]);

	return (
		<PageLayout>
			<MyCollectionLayout
				MyPageMenu={<MyPageMenu />}
				MyCollectionArticle={<MyCollectionArticle articles={articles} />}
				Pagination={
					<Pagination
						currentPage={currentPage}
						totalPages={totalPages}
						setCurrentPage={setCurrentPage}
						size={size}
						currentGroup={currentGroup}
						setCurrentGroup={setCurrentGroup}
					/>
				}
			/>
		</PageLayout>
	);
}

export default MyCollectionPage;
