export interface IArticle {
	articleId: number;
	title: string;
	subTitle: string;
	writer: string;
	publishedDate: [number, number, number, number, number, number, number];
	thumbnailImg: string;
}
