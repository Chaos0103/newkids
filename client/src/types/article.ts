export interface IArticle {
	articleId: number;
	title: string;
	subTitle: string;
	writer: string;
	publishedDate: [number, number, number, number, number, number, number];
	thumbnailImg: string;
}

export interface IArticleDetail {
	title: string;
	subTitle: string;
	writer: string;
	publishedDate: [number, number, number, number, number, number, number];
	content: string;
	thumbnailImg: string;
	imageUrls: string[];
	count: number;
}
