import React, { useState, useEffect } from 'react';
import Footer from 'components/organisms/common/Footer';
import PageLayout from 'layouts/common/PageLayout';
import ArticleFindPageLayout from 'layouts/page/ArticleFindPageLayout';
import SearchOptions from 'components/organisms/article/SearchOptions';
import { IArticle } from 'types/article';
import SearchResultArticleList from 'components/organisms/article/SearchResultArticleList';
import Pagination from 'components/organisms/common/Pagination';
import { dateToString } from 'utils/common/dateToString';
import { setDatebyPeriod } from 'utils/common/setDatebyPeriod';
import { getAllArticleApi } from 'utils/apis/article';

function ArticleFindPage() {
	const [resultArticles, setResultArticles] = useState<IArticle[]>([]);

	// 페이지네이션 관련
	const [currentPage, setCurrentPage] = useState(1);
	const [totalPages, setTotalPages] = useState(1);
	const [size, setSize] = useState(10);
	const [currentGroup, setCurrentGroup] = useState(1);
	const [totalElements, setTotalElements] = useState(0);

	const [startDate, setStartDate] = useState<string>('2000-01-01');
	const [endDate, setEndDate] = useState<string>(dateToString(new Date()));
	const [selectedPeriod, setSelectedPeriod] = useState(0);

	const search = async () => {
		try {
			const response = await getAllArticleApi(startDate, endDate, '', currentPage);
			console.log('::getAllArticleApi', response);

			if (response.status === 200) {
				setResultArticles(response.data.data.content);
				setTotalPages(response.data.data.totalPages);
				setSize(response.data.data.size);
				setTotalElements(response.data.data.totalElements);
			}
		} catch (error) {
			console.log(error);
		}
	};

	useEffect(() => {
		setStartDate(setDatebyPeriod(selectedPeriod));
		setEndDate(dateToString(new Date()));
	}, [selectedPeriod]);

	useEffect(() => {
		search();
	}, [currentPage]);

	return (
		<PageLayout>
			<ArticleFindPageLayout
				SearchOptions={
					<SearchOptions
						startDate={startDate}
						setStartDate={setStartDate}
						endDate={endDate}
						setEndDate={setEndDate}
						selectedPeriod={selectedPeriod}
						setSelectedPeriod={setSelectedPeriod}
						search={search}
						setCurrentPage={setCurrentPage}
						setCurrentGroup={setCurrentGroup}
					/>
				}
				ResultArticleList={
					<SearchResultArticleList articles={resultArticles} totalElements={totalElements} totalPages={totalPages} />
				}
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
				Footer={<Footer />}
			/>
		</PageLayout>
	);
}

export default ArticleFindPage;
