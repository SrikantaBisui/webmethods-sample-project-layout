package PU456_JJAR_Common.pdfUtils;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2017-08-31 02:44:30 EDT
// -----( ON-HOST: itsusralsp03487.jnj.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.data.IDataUtil;
// --- <<IS-END-IMPORTS>> ---

public final class createPDF

{
	// ---( internal utility methods )---

	final static createPDF _instance = new createPDF();

	static createPDF _newInstance() { return new createPDF(); }

	static createPDF _cast(Object o) { return (createPDF)o; }

	// ---( server methods )---




	public static final void generatePDF (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(generatePDF)>> ---
		// @sigtype java 3.5
		// [i] field:0:required activityId
		// [i] field:0:required briefActivityTtle
		// [i] field:0:required milestoneTrackr
		// [i] field:0:required investigationlProdIndicator
		// [i] field:0:required responsibleJnJFunc
		// [i] field:0:required expectedStDt
		// [i] field:0:required interventional
		// [i] field:0:required dataCollctnTyp
		// [i] field:0:required prospective
		// [i] record:1:required countryList
		// [i] - field:0:required countryName
		// [i] - field:0:required expStDt
		// [i] - field:0:required actualStDt
		// [i] - field:0:required status
		// [i] - field:0:required expEndDt
		// [i] - field:0:required actualEndDt
		// [i] - field:0:required healthAuhApprovalReq
		// [i] field:0:required E2BBriefTitle
		// [i] field:0:required SponsoringCompany
		// [i] field:0:required TherapeuticArea
		// [i] field:0:required ActivityObjectives
		// [i] field:0:required NCTNumber
		// [i] field:0:required AlternativeActivityID
		// [i] record:1:required audit
		// [i] - field:0:required user
		// [i] - field:0:required userId
		// [i] - field:0:required eventDescription
		// [i] - field:0:required timeStamp
		// [i] record:1:required comments
		// [i] - field:0:required user
		// [i] - field:0:required role
		// [i] - field:0:required comment
		// [i] - field:0:required timestamp
		// [i] field:0:required vulnerablePopulations
		// [i] field:0:required ae_pqc_ssVendorName
		// [i] field:0:required ae_pqc_ssContactDetails
		// [i] field:0:required activityParticipantCount
		// [i] field:0:required alternativeActivityIdType
		// [i] field:0:required onHoldReason
		// [i] field:0:required stoppedreason
		// [i] field:0:required cancelledReason
		// [i] field:0:required onLineMedia
		// [i] field:0:required responsibleActivityManager
		// [i] field:0:required eudractNumber
		// [i] field:0:required studyPhase
		// [i] field:0:required postMarketing
		// [i] field:0:required planToPublish
		// [i] field:0:required controlGrpType
		// [i] field:0:required safetyEfficacyOfMedicinalProductOrMedicaldevice
		// [i] field:0:required productGivenToParticipants
		// [i] field:0:required aeReporting
		// [i] field:0:required actual1stSubEnrolleddate
		// [i] field:0:required feasibilityStudy
		// [i] field:0:required acceptHealthyVolunteers
		// [i] field:0:required actual1stPatient1stVisitDate
		// [i] field:0:required aggregateParticipantDate
		// [i] field:0:required activityDesignedUpdateLevel
		// [i] field:0:required ResponsibleForLocalregistry
		// [i] field:0:required safetyReviewPlan
		// [i] field:0:required pediatricSubject
		// [i] field:0:required pediatricMinAge
		// [i] field:0:required pediatricMaxAge
		// [i] field:0:required actStrtDate
		// [i] field:0:required ExpEnddate
		// [i] field:0:required actEnddate
		// [i] field:0:required healthOutCmStudy
		// [i] field:0:required healthEcmStudy
		// [i] field:0:required epidemiologyStudy
		// [i] field:0:required drugUtilizationStudt
		// [i] field:0:required postMarketingMainObj
		// [i] field:0:required postMarketingCommitmtInd
		// [i] field:0:required PmcApplicableAuth
		// [i] field:0:required typeForPDF
		// [i] field:0:required activityTitle
		// [i] field:0:required objective
		// [i] field:0:required methodology
		// [i] field:0:required aam
		// [i] field:0:required ram
		// [i] field:0:required sponsorType
		// [i] field:0:required sector
		// [i] field:0:required pausedendDate
		// [i] field:0:required path
		// [i] field:0:required PDF
		// [i] field:0:required imagePath
		// [i] field:0:required timeStamp
		// [i] field:0:required blindingType
		// [i] field:0:required fdaRegulatedIntervention
		// [i] field:0:required dbOfNonSeriousAdverseEvents
		// [i] field:0:required actualPrimaryCompDate
		// [i] field:0:required expPrimaryCompDate
		// [i] record:1:required product
		// [i] - field:0:required productTradeName
		// [i] - field:0:required dosageForm
		// [i] - field:0:required strength
		// [i] - field:0:required country
		// [i] - field:0:required primary_Indication
		// [i] - field:0:required activeIngredient
		// [i] - field:0:required productRoute
		// [i] - field:0:required source
		// [i] - field:0:required brandName
		// [i] field:0:required primaryIndicationUnderStudy
		// [i] record:1:optional alternateActivity
		// [i] - field:0:required id
		// [i] - field:0:required type
		// [i] field:0:required pass
		// [i] field:0:required ae_pqc_ss_cont
		// [i] field:0:required ae_pqc_ss_email
		// [i] field:0:required documentLocation
		// [i] field:0:required IND_IDE_Indicator
		// [i] field:0:required IND_IDE_Grantor
		// [i] field:0:required IND_IDE_Number
		// [i] record:1:required product_pharma
		// [i] - field:0:optional source
		// [i] - field:0:required usSubstanceName
		// [i] - field:0:optional substanceJnJNumber
		// [i] - field:0:optional activeIngredient
		// [i] - field:0:optional dosageForm
		// [i] - field:0:optional primaryProductIndicator
		// [i] - field:0:optional productRouteOfAdministration
		// [i] - field:0:required brandName
		// [i] field:0:required fontJARpath
		// [i] field:0:required actsource
		// [i] field:0:required brandLevel
		// [i] field:0:required mira
		// [i] field:0:required eligiblePSMF
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		FILE = IDataUtil.getString( pipelineCursor, "path" );
		String imagePath=IDataUtil.getString( pipelineCursor, "imagePath" );
		String	typeForPDF = IDataUtil.getString( pipelineCursor, "typeForPDF" );
		PDF = IDataUtil.getString( pipelineCursor, "PDF" );
		timeNow=IDataUtil.getString( pipelineCursor, "timeStamp" );
		activityId = IDataUtil.getString( pipelineCursor, "activityId" );
		briefActivityTtle = IDataUtil.getString( pipelineCursor, "briefActivityTtle" );
		milestoneTrackr = IDataUtil.getString( pipelineCursor, "milestoneTrackr" );
		String	investigationlProdIndicator = IDataUtil.getString( pipelineCursor, "investigationlProdIndicator" );
		String	responsibleJnJFunc = IDataUtil.getString( pipelineCursor, "responsibleJnJFunc" );
		String	expectedStDt = IDataUtil.getString( pipelineCursor, "expectedStDt" );
		String	interventional = IDataUtil.getString( pipelineCursor, "interventional" );
		String	dataCollctnTyp = IDataUtil.getString( pipelineCursor, "dataCollctnTyp" );
		String	prospective = IDataUtil.getString( pipelineCursor, "prospective" );
		String	activityTitle = IDataUtil.getString( pipelineCursor, "activityTitle" );
		String	objective = IDataUtil.getString( pipelineCursor, "objective" );
		String	methodology = IDataUtil.getString( pipelineCursor, "methodology" );
		String	aam = IDataUtil.getString( pipelineCursor, "aam" );
		String	ram = IDataUtil.getString( pipelineCursor, "ram" );
		String	sponsorType = IDataUtil.getString( pipelineCursor, "sponsorType" );
		sector = IDataUtil.getString( pipelineCursor, "sector" );
		String	pausedendDate = IDataUtil.getString( pipelineCursor, "pausedendDate" );
		E2BBriefTitle = IDataUtil.getString( pipelineCursor, "E2BBriefTitle" );
		String	SponsoringCompany = IDataUtil.getString( pipelineCursor, "SponsoringCompany" );
		String	TherapeuticArea = IDataUtil.getString( pipelineCursor, "TherapeuticArea" );
		String	ActivityObjectives = IDataUtil.getString( pipelineCursor, "ActivityObjectives" );
		String	NCTNumber = IDataUtil.getString( pipelineCursor, "NCTNumber" );
		String	AlternativeActivityID = IDataUtil.getString( pipelineCursor, "AlternativeActivityID" );
		String	vulnerablePopulations = IDataUtil.getString( pipelineCursor, "vulnerablePopulations" );
		String	ae_pqc_ssVendorName = IDataUtil.getString( pipelineCursor, "ae_pqc_ssVendorName" );
		String	ae_pqc_ssContactDetails = IDataUtil.getString( pipelineCursor, "ae_pqc_ssContactDetails" );
		String	activityParticipantCount = IDataUtil.getString( pipelineCursor, "activityParticipantCount" );
		String	alternativeActivityIdType = IDataUtil.getString( pipelineCursor, "alternativeActivityIdType" );
		String	onHoldReason = IDataUtil.getString( pipelineCursor, "onHoldReason" );
		String	stoppedreason = IDataUtil.getString( pipelineCursor, "stoppedreason" );
		String	cancelledReason = IDataUtil.getString( pipelineCursor, "cancelledReason" );
		String	onLineMedia = IDataUtil.getString( pipelineCursor, "onLineMedia" );
		String	responsibleActivityManager = IDataUtil.getString( pipelineCursor, "responsibleActivityManager" );
		String	eudractNumber = IDataUtil.getString( pipelineCursor, "eudractNumber" );
		String	studyPhase = IDataUtil.getString( pipelineCursor, "studyPhase" );
		String	postMarketing = IDataUtil.getString( pipelineCursor, "postMarketing" );
		String	planToPublish = IDataUtil.getString( pipelineCursor, "planToPublish" );
		String	controlGrpType = IDataUtil.getString( pipelineCursor, "controlGrpType" );
		String	safetyEfficacyOfMedicinalProductOrMedicaldevice = IDataUtil.getString( pipelineCursor, "safetyEfficacyOfMedicinalProductOrMedicaldevice");
		String	productGivenToParticipants = IDataUtil.getString( pipelineCursor, "productGivenToParticipants" );
		String	actual1stSubEnrolleddate = IDataUtil.getString( pipelineCursor, "actual1stSubEnrolleddate" );
		String	feasibilityStudy = IDataUtil.getString( pipelineCursor, "feasibilityStudy" );
		String	acceptHealthyVolunteers = IDataUtil.getString( pipelineCursor, "acceptHealthyVolunteers" );
		String	actual1stPatient1stVisitDate = IDataUtil.getString( pipelineCursor, "actual1stPatient1stVisitDate" );
		String	aggregateParticipantDate = IDataUtil.getString( pipelineCursor, "aggregateParticipantDate" );
		String	activityDesignedUpdateLevel = IDataUtil.getString( pipelineCursor, "activityDesignedUpdateLevel" );
		String	ResponsibleForLocalregistry = IDataUtil.getString( pipelineCursor, "ResponsibleForLocalregistry" );
		String	safetyReviewPlan = IDataUtil.getString( pipelineCursor, "safetyReviewPlan" );
		String	aeReporting = IDataUtil.getString( pipelineCursor, "aeReporting" );
		String	pediatricSubject = IDataUtil.getString( pipelineCursor, "pediatricSubject" );
		String	pediatricMinAge = IDataUtil.getString( pipelineCursor, "pediatricMinAge" );
		String	pediatricMaxAge = IDataUtil.getString( pipelineCursor, "pediatricMaxAge" );
		String	actStrtDate = IDataUtil.getString( pipelineCursor, "actStrtDate" );
		String	ExpEnddate = IDataUtil.getString( pipelineCursor, "ExpEnddate" );
		String	actEnddate = IDataUtil.getString( pipelineCursor, "actEnddate" );
		String	healthOutCmStudy = IDataUtil.getString( pipelineCursor, "healthOutCmStudy" );
		String	healthEcmStudy = IDataUtil.getString( pipelineCursor, "healthEcmStudy" );
		String	epidemiologyStudy = IDataUtil.getString( pipelineCursor, "epidemiologyStudy" );
		String	drugUtilizationStudt = IDataUtil.getString( pipelineCursor, "drugUtilizationStudt" );
		String	postMarketingMainObj = IDataUtil.getString( pipelineCursor, "postMarketingMainObj" );
		String	postMarketingCommitmtInd = IDataUtil.getString( pipelineCursor, "postMarketingCommitmtInd" );
		String	PmcApplicableAuth = IDataUtil.getString( pipelineCursor, "PmcApplicableAuth" );
		String	blindingType = IDataUtil.getString( pipelineCursor, "blindingType" );
		String	fdaRegulatedIntervention = IDataUtil.getString( pipelineCursor, "fdaRegulatedIntervention" );
		String	dbOfNonSeriousAdverseEvents = IDataUtil.getString( pipelineCursor, "dbOfNonSeriousAdverseEvents" );
		String	actualPrimaryCompDate = IDataUtil.getString( pipelineCursor, "actualPrimaryCompDate" );
		String	expPrimaryCompDate = IDataUtil.getString( pipelineCursor, "expPrimaryCompDate" );
		String  primaryIndicationUnderStudy = IDataUtil.getString( pipelineCursor, "primaryIndicationUnderStudy" );
		String  pass = IDataUtil.getString( pipelineCursor, "pass" );
		String  ae_pqc_ss_email = IDataUtil.getString( pipelineCursor,"ae_pqc_ss_email");
		String  ae_pqc_ss_cont = IDataUtil.getString( pipelineCursor, "ae_pqc_ss_cont");
		String  IND_IDE_Indicator = IDataUtil.getString( pipelineCursor, "IND_IDE_Indicator");
		String  IND_IDE_Grantor = IDataUtil.getString( pipelineCursor, "IND_IDE_Grantor");
		String  IND_IDE_Number = IDataUtil.getString( pipelineCursor, "IND_IDE_Number");
		String  documentLocation = IDataUtil.getString( pipelineCursor, "documentLocation");
		String  mira = IDataUtil.getString( pipelineCursor, "mira");
		fontJARpath = IDataUtil.getString( pipelineCursor, "fontJARpath");
		actsource  = IDataUtil.getString( pipelineCursor,"actsource");
		brandLevel = IDataUtil.getString( pipelineCursor,"brandLevel");
		String eligiblePSMF =IDataUtil.getString( pipelineCursor,"eligiblePSMF");
		
		IData[]	countryList = IDataUtil.getIDataArray( pipelineCursor, "countryList" );
		IData[]	audit = IDataUtil.getIDataArray( pipelineCursor, "audit" );
		IData[]	comments = IDataUtil.getIDataArray( pipelineCursor, "comments" );
		IData[]	productList = IDataUtil.getIDataArray( pipelineCursor, "product" );
		IData[]	alternateActivity = IDataUtil.getIDataArray( pipelineCursor, "alternateActivity" );
		IData[]	phrmaproductList = IDataUtil.getIDataArray( pipelineCursor, "product_pharma" );
			
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("imagePath", imagePath);
		mp.put("path", path);
		mp.put("activityId", activityId);
		mp.put("PDF", PDF);
		mp.put("timeNow", timeNow);
		mp.put("milestoneTrackr", milestoneTrackr);
		mp.put("briefActivityTtle", briefActivityTtle);
		mp.put("investigationlProdIndicator", investigationlProdIndicator);
		mp.put("responsibleJnJFunc", responsibleJnJFunc);
		mp.put("expectedStDt", expectedStDt);
		mp.put("interventional", interventional);
		mp.put("dataCollctnTyp", dataCollctnTyp);
		mp.put("prospective", prospective);
		mp.put("E2BBriefTitle", E2BBriefTitle);
		mp.put("SponsoringCompany", SponsoringCompany);
		mp.put("TherapeuticArea", TherapeuticArea);
		mp.put("ActivityObjectives", ActivityObjectives);
		mp.put("NCTNumber", NCTNumber);
		mp.put("AlternativeActivityID", AlternativeActivityID);
		mp.put("vulnerablePopulations", vulnerablePopulations);
		mp.put("ae_pqc_ssVendorName", ae_pqc_ssVendorName);
		mp.put("ae_pqc_ssContactDetails", ae_pqc_ssContactDetails);
		mp.put("activityParticipantCount", activityParticipantCount);
		mp.put("alternativeActivityIdType", alternativeActivityIdType);
		mp.put("onHoldReason", onHoldReason);
		mp.put("stoppedreason", stoppedreason);
		mp.put("cancelledReason", cancelledReason);
		mp.put("onLineMedia", onLineMedia);
		mp.put("responsibleActivityManager", responsibleActivityManager);
		mp.put("eudractNumber", eudractNumber);
		mp.put("studyPhase", studyPhase);
		mp.put("postMarketing", postMarketing);
		mp.put("planToPublish", planToPublish);
		mp.put("controlGrpType", controlGrpType);
		mp.put("safetyEfficacyOfMedicinalProductOrMedicaldevice", safetyEfficacyOfMedicinalProductOrMedicaldevice);
		mp.put("productGivenToParticipants", productGivenToParticipants);
		mp.put("actual1stSubEnrolleddate", actual1stSubEnrolleddate);
		mp.put("acceptHealthyVolunteers", acceptHealthyVolunteers);
		mp.put("feasibilityStudy", feasibilityStudy);
		mp.put("actual1stPatient1stVisitDate", actual1stPatient1stVisitDate);
		mp.put("aggregateParticipantDate", aggregateParticipantDate);
		mp.put("activityDesignedUpdateLevel", activityDesignedUpdateLevel);
		mp.put("ResponsibleForLocalregistry", ResponsibleForLocalregistry);
		mp.put("safetyReviewPlan", safetyReviewPlan);
		mp.put("aeReporting",aeReporting);
		mp.put("activityTitle", activityTitle);
		mp.put("objective", objective);
		mp.put("methodology", methodology);
		mp.put("aam", aam);
		mp.put("ram", ram);
		mp.put("sponsorType", sponsorType);
		mp.put("sector", sector);
		mp.put("pausedendDate", pausedendDate);
		mp.put("blindingType", blindingType);
		mp.put("fdaRegulatedIntervention", fdaRegulatedIntervention);
		mp.put("dbOfNonSeriousAdverseEvents", dbOfNonSeriousAdverseEvents);
		mp.put("actualPrimaryCompDate", actualPrimaryCompDate);
		mp.put("expPrimaryCompDate", expPrimaryCompDate);
		mp.put("primaryIndicationUnderStudy",primaryIndicationUnderStudy);
		mp.put("ae_pqc_ss_email",ae_pqc_ss_email);
		mp.put("ae_pqc_ss_cont",ae_pqc_ss_cont);
		mp.put("IND_IDE_Indicator",IND_IDE_Indicator);
		mp.put("IND_IDE_Grantor",IND_IDE_Grantor);
		mp.put("IND_IDE_Number",IND_IDE_Number);
		mp.put("pedSubject1YrOld", pediatricSubject);
		mp.put("pedMinAge", pediatricMinAge);
		mp.put("pedMaxAge", pediatricMaxAge); 
		mp.put("acStDt", actStrtDate);
		mp.put("exEndDt", ExpEnddate);
		mp.put("AcEndDt", actEnddate);
		mp.put("healthOutcomesStd", healthOutCmStudy);
		mp.put("healthEcoStd", healthEcmStudy);
		mp.put("epidemiologyStd", epidemiologyStudy);
		mp.put("drugUtiStd", drugUtilizationStudt);
		mp.put("mainObj", postMarketingMainObj);
		mp.put("comIndicator", postMarketingCommitmtInd);
		mp.put("appAuth", PmcApplicableAuth);
		mp.put("pass", pass);
		mp.put("documentLocation",documentLocation);
		mp.put("fontJARpath",fontJARpath);
		mp.put("actsource",actsource);
		mp.put("brandLevel",brandLevel);
		mp.put("mira",mira);
		mp.put("eligiblePSMF",eligiblePSMF);
		
		
		
		ArrayList<HashMap<String, String>> countryhmList = new ArrayList<HashMap<String,String>>();
		ArrayList<HashMap<String, String>> audithmList = new ArrayList<HashMap<String,String>>();
		ArrayList<HashMap<String, String>> commentshmList = new ArrayList<HashMap<String,String>>();
		ArrayList<HashMap<String, String>> producthmList = new ArrayList<HashMap<String,String>>();
		ArrayList<HashMap<String, String>> alternateActivityhmList = new ArrayList<HashMap<String,String>>();
		ArrayList<HashMap<String, String>> phrmaproducthmList = new ArrayList<HashMap<String,String>>();
		
		
		if ( alternateActivity != null)
		{
			for ( int i = 0; i < alternateActivity.length; i++ )
			{
				IDataCursor alternateActivityCursor = alternateActivity[i].getCursor();
				
				String	id = IDataUtil.getString( alternateActivityCursor, "id" );
				String	type = IDataUtil.getString( alternateActivityCursor, "type" );
				
				
				HashMap<String, String> alternateActivitymp = new HashMap<String, String>();
				
				alternateActivitymp.put("id", id);
				alternateActivitymp.put("type", type);
				
				
				alternateActivityhmList.add(alternateActivitymp);
				
				alternateActivityCursor.destroy();
			}
		}
		
		if ( countryList != null)
		{
			for ( int i = 0; i < countryList.length; i++ )
			{
				IDataCursor countryListCursor = countryList[i].getCursor();
					String	countryName = IDataUtil.getString( countryListCursor, "countryName" );
					String	expStDt = IDataUtil.getString( countryListCursor, "expStDt" );
					String	actualStDt = IDataUtil.getString( countryListCursor, "actualStDt" );
					String	status = IDataUtil.getString( countryListCursor, "status" );
					String	expEndDt = IDataUtil.getString( countryListCursor, "expEndDt" );
					String	actualEndDt = IDataUtil.getString( countryListCursor, "actualEndDt" );
					String  healthAuhApprovalReq = IDataUtil.getString( countryListCursor, "healthAuhApprovalReq");
					
					
					
				HashMap<String, String> countrymp = new HashMap<String, String>();
					
				countrymp.put("countryName", countryName);
				countrymp.put("expStDt", expStDt);
				countrymp.put("actualStDt", actualStDt);
				countrymp.put("expEndDt", expEndDt);
				countrymp.put("actualEndDt", actualEndDt);
				countrymp.put("status", status);
				countrymp.put("healthAuhApprovalReq", healthAuhApprovalReq);
				
				countryhmList.add(countrymp);
				countryListCursor.destroy();
			}
		}
		
		
		if ( audit != null)
		{
			for ( int i = 0; i < audit.length; i++ )
			{
				IDataCursor auditListCursor = audit[i].getCursor();
					String	user = IDataUtil.getString( auditListCursor, "user" );
					String	userId = IDataUtil.getString( auditListCursor, "userId" );
					String	eventDescription = IDataUtil.getString( auditListCursor, "eventDescription" );
					String	timeStamp = IDataUtil.getString( auditListCursor, "timeStamp" );
								
				HashMap<String, String> auditmp = new HashMap<String, String>();
					
				auditmp.put("user", user);
				auditmp.put("userId", userId);
				auditmp.put("eventDescription", eventDescription);
				auditmp.put("timeStamp", timeStamp);
				
				audithmList.add(auditmp);
				
				auditListCursor.destroy();
			}
		}
		
		
		if ( productList != null)
		{
			for ( int i = 0; i < productList.length; i++ )
			{
				IDataCursor productListCursor = productList[i].getCursor();
					
				String	productTradeName = IDataUtil.getString( productListCursor, "productTradeName" );
				String	dosageForm = IDataUtil.getString( productListCursor, "dosageForm" );
				String	strength = IDataUtil.getString( productListCursor, "strength" );
				String	country = IDataUtil.getString( productListCursor, "country" );
				String	primary_Indication = IDataUtil.getString( productListCursor, "primary_Indication" );
				String	activeIngredient = IDataUtil.getString( productListCursor, "activeIngredient" );
				String	productRoute = IDataUtil.getString( productListCursor, "productRoute" );
				String	source = IDataUtil.getString( productListCursor, "source" );
				String  brandName = IDataUtil.getString( productListCursor, "brandName");
								
				HashMap<String, String> productmp = new HashMap<String, String>();
					
				productmp.put("productTradeName", productTradeName);
				productmp.put("dosageForm", dosageForm);
				productmp.put("strength", strength);
				productmp.put("country", country);
				productmp.put("primary_Indication", primary_Indication);
				productmp.put("activeIngredient", activeIngredient);
				productmp.put("productRoute", productRoute);
				productmp.put("source", source);
				productmp.put("brandName",brandName);
				
				producthmList.add(productmp);
				
				productListCursor.destroy();
			}
		}
		
		
		if ( phrmaproductList != null)
		{
			for ( int i = 0; i < phrmaproductList.length; i++ )
			{
				IDataCursor pharmaproductListCursor = phrmaproductList[i].getCursor();
					
				String	usSubstanceName = IDataUtil.getString( pharmaproductListCursor, "usSubstanceName" );
				String	dosageForm = IDataUtil.getString( pharmaproductListCursor, "dosageForm" );
				String	substanceJnJNumber = IDataUtil.getString( pharmaproductListCursor, "substanceJnJNumber" );
				String	activeIngredient = IDataUtil.getString( pharmaproductListCursor, "activeIngredient" );
				String	primaryProductIndicator = IDataUtil.getString( pharmaproductListCursor, "primaryProductIndicator" );
				String	productRouteOfAdministration = IDataUtil.getString( pharmaproductListCursor, "productRouteOfAdministration" );
				String	source = IDataUtil.getString( pharmaproductListCursor, "source" );
								
				HashMap<String, String> productPharmamp = new HashMap<String, String>();
					
				productPharmamp.put("dosageForm", dosageForm);
				productPharmamp.put("usSubstanceName", usSubstanceName);
				productPharmamp.put("substanceJnJNumber", substanceJnJNumber);
				productPharmamp.put("primaryProductIndicator", primaryProductIndicator);
				productPharmamp.put("activeIngredient", activeIngredient);
				productPharmamp.put("productRouteOfAdministration", productRouteOfAdministration);
				productPharmamp.put("source", source);
				
				
				phrmaproducthmList.add(productPharmamp);
				
				pharmaproductListCursor.destroy();
			}
		}
		
		
		if ( comments != null)
		{
			for ( int i = 0; i < comments.length; i++ )
			{
				IDataCursor commentsListCursor = comments[i].getCursor();
					String	user = IDataUtil.getString( commentsListCursor, "user" );
					String	role = IDataUtil.getString( commentsListCursor, "role" );
					String	comment = IDataUtil.getString( commentsListCursor, "comment" );
					String	timestamp = IDataUtil.getString( commentsListCursor, "timestamp" );
					
					
					
					
				HashMap<String, String> commentmp = new HashMap<String, String>();
					
				commentmp.put("user", user);
				commentmp.put("role", role);
				commentmp.put("comment", comment);
				commentmp.put("timestamp", timestamp);
				
				
				commentshmList.add(commentmp);
				
				commentsListCursor.destroy();
			}
		}
			try {
				
								
				topBanner = Image.getInstance(imagePath);
				Document document = new Document();
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
				
				HeadFoot event = new HeadFoot();
				writer.setPageEvent(event);
				
				document.open();
				
				if (typeForPDF!=null && typeForPDF.equalsIgnoreCase("all")){
				
				setupInfo(document,mp);
				
				document.newPage();
				setupInfoCountries(document,countryhmList);
				
				document.newPage();
				
				if (sector.equalsIgnoreCase("Consumer")){
				productInfo(document,producthmList);}
				else{
				productInfo_pharma(document,phrmaproducthmList);}
				
				document.newPage();
				if (sector.equalsIgnoreCase("Consumer")){
				setupInfoGeneralExecution(document,mp,alternateActivityhmList);}
				else{
					setupInfoGeneralExecutionPharma(document,mp,alternateActivityhmList);
				}
				
				//document.newPage();
				//executionEtc(document,executionEtcMap);
				
							
				//document.newPage();
			//	setupInfoConsumerPharma(document,mp);
				
				document.newPage();
				setupInfoAudit(document,audithmList);
					
				document.newPage();
				setupInfoComments(document,commentshmList);
				
				}
				
				else if (typeForPDF!=null && typeForPDF.equalsIgnoreCase("creation")){
					
					setupInfo(document,mp);
				}
				else if (typeForPDF!=null && typeForPDF.equalsIgnoreCase("identification")){
					
					//setupInfoGeneralExecution(document,mp,alternateActivityhmList);
					
					if (sector.equalsIgnoreCase("Consumer")){
						setupInfoGeneralExecution(document,mp,alternateActivityhmList);}
						else{
							setupInfoGeneralExecutionPharma(document,mp,alternateActivityhmList);
						}
					//document.newPage();
					//executionEtc(document,executionEtcMap);
				//	setupInfoConsumerPharma(document,mp);
				}
				
				else if (typeForPDF!=null && typeForPDF.equalsIgnoreCase("summary")){
					
					setupInfo(document,mp);
					document.newPage();
					
					if (sector.equalsIgnoreCase("Consumer")){
						setupInfoGeneralExecution(document,mp,alternateActivityhmList);}
						else{
							setupInfoGeneralExecutionPharma(document,mp,alternateActivityhmList);
						}
				//	setupInfoGeneralExecution(document,mp,alternateActivityhmList);
				//	document.newPage();
				//	executionEtc(document,executionEtcMap);
					
				//	setupInfoConsumerPharma(document,mp);
				}
				else if (typeForPDF!=null && typeForPDF.equalsIgnoreCase("audit")){
					
					setupInfoAudit(document,audithmList);
				}
				else if (typeForPDF!=null && typeForPDF.equalsIgnoreCase("comments")){
					
					setupInfoComments(document,commentshmList);
				}
				
				document.close();
				
				
			}  catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		// --- <<IS-END>> ---

                
	}



	public static final void generatePDF_Audit (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(generatePDF_Audit)>> ---
		// @sigtype java 3.5
		// [i] record:1:required audit
		// [i] - field:0:required user
		// [i] - field:0:required userId
		// [i] - field:0:required eventDescription
		// [i] - field:0:required timeStamp
		// [i] field:0:required path
		// [i] field:0:required imagePath
		// [i] field:0:required PDF
		// [i] field:0:required activityId
		// [i] field:0:required timeStamp
		// [i] field:0:required fontJARpath
		// [i] field:0:optional eventType
		// [i] field:0:optional userName
		// [i] field:0:optional referenceDataList
		// [i] field:0:optional ruleVariable
		// [i] field:0:optional FromDate
		// [i] field:0:optional ToDate
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		FILE = IDataUtil.getString( pipelineCursor, "path" );
		String imagePath=IDataUtil.getString( pipelineCursor, "imagePath" );
		PDF = IDataUtil.getString( pipelineCursor, "PDF" );
		timeNow=IDataUtil.getString( pipelineCursor, "timeStamp" );
		activityId=IDataUtil.getString( pipelineCursor, "activityId" );
		String eventType=IDataUtil.getString( pipelineCursor, "eventType" );
		String userName=IDataUtil.getString( pipelineCursor, "userName" );
		String referenceDataList=IDataUtil.getString( pipelineCursor, "referenceDataList" );
		String ruleVariable=IDataUtil.getString( pipelineCursor, "ruleVariable" );
		String FromDate=IDataUtil.getString( pipelineCursor, "FromDate" );
		String ToDate=IDataUtil.getString( pipelineCursor, "ToDate");
		fontJARpath = IDataUtil.getString( pipelineCursor, "fontJARpath");
		
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("imagePath", imagePath);
		mp.put("path", path);
		mp.put("PDF", PDF);
		mp.put("timeNow", timeNow);
		mp.put("activityId", activityId);
		mp.put("referenceDataList", referenceDataList);
		mp.put("eventType", eventType);
		mp.put("userName",userName);
		mp.put("ruleVariable",ruleVariable);
		mp.put("FromDate",FromDate);
		mp.put("ToDate",ToDate);
		
			// audit
			IData[]	audit = IDataUtil.getIDataArray( pipelineCursor, "audit" );
			
			ArrayList<HashMap<String, String>> auditList = new ArrayList<HashMap<String,String>>();
			
			if ( audit != null)
			{
				for ( int i = 0; i < audit.length; i++ )
				{
					IDataCursor auditCursor = audit[i].getCursor();
						String	user = IDataUtil.getString( auditCursor, "user" );
						String	userId = IDataUtil.getString( auditCursor, "userId" );
						String	eventDescription = IDataUtil.getString( auditCursor, "eventDescription" );
						String	timeStamp = IDataUtil.getString( auditCursor, "timeStamp" );
						
						HashMap<String, String> auditmp = new HashMap<String, String>();
						
						auditmp.put("user", user);
						auditmp.put("userId", userId);
						auditmp.put("eventDescription", eventDescription);
						auditmp.put("timeStamp", timeStamp);
						
						auditList.add(auditmp);
						
					auditCursor.destroy();
				}
			}
		pipelineCursor.destroy();
		
		
		try {
			
			
			topBanner = Image.getInstance(imagePath);
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
			
			HeadFoot event = new HeadFoot();
			writer.setPageEvent(event);
			
			document.open();
			
			
			{
				setupInfoAuditTab(document,mp,auditList);
			
			}
			
			document.close();
			
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		// pipeline
			
		// --- <<IS-END>> ---

                
	}



	public static final void generatePDF_Country (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(generatePDF_Country)>> ---
		// @sigtype java 3.5
		// [i] field:0:required activityId
		// [i] field:0:required briefActivityTtle
		// [i] field:0:required E2BBriefTitle
		// [i] field:0:required activityTitle
		// [i] field:0:required objective
		// [i] field:0:required methodology
		// [i] field:0:required sponsorType
		// [i] field:0:required aam
		// [i] field:0:required ram
		// [i] field:0:required sector
		// [i] field:0:required activityStatus
		// [i] field:0:required actualActiitySrtDate
		// [i] field:0:required countryStatus
		// [i] field:0:required expectedSrtDate
		// [i] field:0:required actualsrtDate
		// [i] field:0:required expected1stSiteOpenedDate
		// [i] field:0:required actual1stsubEnrolledDate
		// [i] field:0:required expectedHAProtocalApprovaldate
		// [i] field:0:required actualHAProtocalApprovaldate
		// [i] field:0:required expectedIRB_IECApprovalDate
		// [i] field:0:required actualIRB_IECApprovalDate
		// [i] field:0:required expectedEndDate
		// [i] field:0:required actualEnddate
		// [i] record:1:required audit
		// [i] - field:0:required user
		// [i] - field:0:required userId
		// [i] - field:0:required eventDescription
		// [i] - field:0:required timeStamp
		// [i] field:0:required activityMileStoneTrackerStatus
		// [i] field:0:required countryMileStoneTrackerStatus
		// [i] field:0:required path
		// [i] field:0:required type
		// [i] field:0:required actual1stparticipantEnrolledDate
		// [i] field:0:required countryName
		// [i] field:0:required PDF
		// [i] field:0:required ActivitypauseEndDate
		// [i] field:0:required actualActiityEndDate
		// [i] field:0:required expActivitySrtDate
		// [i] field:0:required expActivityEndDate
		// [i] field:0:required imagePath
		// [i] field:0:required timeStamp
		// [i] field:0:required fontJARpath
		// [i] field:0:required healthAuhorityApprovalReq
		// [i] field:0:required IRBIECApprovalRequired
			IDataCursor pipelineCursor = pipeline.getCursor();
			
			String imagePath=IDataUtil.getString( pipelineCursor, "imagePath" );
			FILE = IDataUtil.getString( pipelineCursor, "path" );
			PDF = IDataUtil.getString( pipelineCursor, "PDF" );
			timeNow=IDataUtil.getString( pipelineCursor, "timeStamp" );
			activityId = IDataUtil.getString( pipelineCursor, "activityId" );
			countryName = IDataUtil.getString( pipelineCursor, "countryName" );
			String	type = IDataUtil.getString( pipelineCursor, "type" );
			briefActivityTtle = IDataUtil.getString( pipelineCursor, "briefActivityTtle" );
			String	E2BBriefTitle = IDataUtil.getString( pipelineCursor, "E2BBriefTitle" );
			String	activityTitle = IDataUtil.getString( pipelineCursor, "activityTitle" );
			String	objective = IDataUtil.getString( pipelineCursor, "objective" );
			String	methodology = IDataUtil.getString( pipelineCursor, "methodology" );
			String	sponsorType = IDataUtil.getString( pipelineCursor, "sponsorType" );
			String	aam = IDataUtil.getString( pipelineCursor, "aam" );
			String	ram = IDataUtil.getString( pipelineCursor, "ram" );
			String	sector = IDataUtil.getString( pipelineCursor, "sector" );
			String	activityStatus = IDataUtil.getString( pipelineCursor, "activityStatus" );
			String	actualActiitySrtDate = IDataUtil.getString( pipelineCursor, "actualActiitySrtDate" );
			String	countryStatus = IDataUtil.getString( pipelineCursor, "countryStatus" );
			String	expectedSrtDate = IDataUtil.getString( pipelineCursor, "expectedSrtDate" );
			String	actualsrtDate = IDataUtil.getString( pipelineCursor, "actualsrtDate" );
			String  healthAuhorityApprovalReq = IDataUtil.getString( pipelineCursor, "healthAuhorityApprovalReq");
			String  IRBIECApprovalRequired = IDataUtil.getString( pipelineCursor, "IRBIECApprovalRequired");
		//	String	expected1stSiteOpenedDate = IDataUtil.getString( pipelineCursor, "expected1stSiteOpenedDate" );
		//		String	actual1stsubEnrolledDate = IDataUtil.getString( pipelineCursor, "actual1stsubEnrolledDate" );
		//		String	actual1stparticipantEnrolledDate = IDataUtil.getString( pipelineCursor, "actual1stparticipantEnrolledDate" );
		//	String	expectedHAProtocalApprovaldate = IDataUtil.getString( pipelineCursor, "expectedHAProtocalApprovaldate" );
		//	String	actualHAProtocalApprovaldate = IDataUtil.getString( pipelineCursor, "actualHAProtocalApprovaldate" );
		//	String	expectedIRB_IECApprovalDate = IDataUtil.getString( pipelineCursor, "expectedIRB_IECApprovalDate" );
		//	String	actualIRB_IECApprovalDate = IDataUtil.getString( pipelineCursor, "actualIRB_IECApprovalDate" );
			String	expectedEndDate = IDataUtil.getString( pipelineCursor, "expectedEndDate" );
			String	actualEnddate = IDataUtil.getString( pipelineCursor, "actualEnddate" );
			activityMileStoneTrackerStatus = IDataUtil.getString( pipelineCursor, "activityMileStoneTrackerStatus" );
			countryMileStoneTrackerStatus = IDataUtil.getString( pipelineCursor, "countryMileStoneTrackerStatus" );
			String expActivitySrtDate = IDataUtil.getString( pipelineCursor,"expActivitySrtDate");
			fontJARpath = IDataUtil.getString( pipelineCursor, "fontJARpath");
			
			Map<String, String> mp = new HashMap<String, String>();
			mp.put("imagePath", imagePath);
			mp.put("path", path);
			mp.put("PDF", PDF);
			mp.put("timeNow", timeNow);
			mp.put("type", type);
			mp.put("activityId", activityId);
			mp.put("countryName", countryName);
			mp.put("briefActivityTtle", briefActivityTtle);
			mp.put("E2BBriefTitle", E2BBriefTitle);
			mp.put("activityTitle", activityTitle);
			mp.put("objective", objective);
			mp.put("methodology", methodology);
			mp.put("sponsorType", sponsorType);
			mp.put("aam", aam);
			mp.put("ram", ram);
			mp.put("sector", sector);
			mp.put("activityStatus", activityStatus);
			mp.put("actualActiitySrtDate", actualActiitySrtDate);
			mp.put("countryStatus", countryStatus);
			mp.put("actualsrtDate", actualsrtDate);
			mp.put("expectedSrtDate", expectedSrtDate);
			mp.put("healthAuhorityApprovalReq", healthAuhorityApprovalReq);
			mp.put("IRBIECApprovalRequired",IRBIECApprovalRequired);
		//	mp.put("actual1stsubEnrolledDate", actual1stsubEnrolledDate);
		//	mp.put("actual1stparticipantEnrolledDate",actual1stparticipantEnrolledDate);
		//	mp.put("expectedHAProtocalApprovaldate", expectedHAProtocalApprovaldate);
		//	mp.put("actualHAProtocalApprovaldate", actualHAProtocalApprovaldate);
		//	mp.put("expectedIRB_IECApprovalDate", expectedIRB_IECApprovalDate);
		//	mp.put("actualIRB_IECApprovalDate", actualIRB_IECApprovalDate);
			mp.put("expectedEndDate", expectedEndDate);
			mp.put("actualEnddate", actualEnddate);
			mp.put("activityMileStoneTrackerStatus", activityMileStoneTrackerStatus);
			mp.put("countryMileStoneTrackerStatus", countryMileStoneTrackerStatus);
			mp.put("expActivitySrtDate",expActivitySrtDate);
			mp.put("fontJARpath",fontJARpath);
			
			IData[]	audit = IDataUtil.getIDataArray( pipelineCursor, "audit" );
			
			ArrayList<HashMap<String, String>> audithmList = new ArrayList<HashMap<String,String>>();
			
			
			if ( audit != null)
			{
				for ( int i = 0; i < audit.length; i++ )
				{
					IDataCursor auditListCursor = audit[i].getCursor();
						String	user = IDataUtil.getString( auditListCursor, "user" );
						String	userId = IDataUtil.getString( auditListCursor, "userId" );
						String	eventDescription = IDataUtil.getString( auditListCursor, "eventDescription" );
						String	timeStamp = IDataUtil.getString( auditListCursor, "timeStamp" );
									
					HashMap<String, String> auditmp = new HashMap<String, String>();
						
					auditmp.put("user", user);
					auditmp.put("userId", userId);
					auditmp.put("eventDescription", eventDescription);
					auditmp.put("timeStamp", timeStamp);
					
					
					audithmList.add(auditmp);
					
					auditListCursor.destroy();
				}
			}
			
		
			try {
				
			
			topBanner = Image.getInstance(imagePath);
			
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
			
			HeadFoot event = new HeadFoot();
			writer.setPageEvent(event);
			
			document.open();
			
			if (type!=null && type.equalsIgnoreCase("all")){			
			setupActivityInfo(document,mp);
			countryInfo(document,mp);
			
			document.newPage();
			
			setupInfoAudit(document,audithmList);
				
			}	
			else if (type!=null && type.equalsIgnoreCase("country")){
				setupActivityInfo(document,mp);
				countryInfo(document,mp);
			}
			
			else if (type!=null && type.equalsIgnoreCase("audit")){
				setupActivityInfo(document,mp);
				setupInfoAudit(document,audithmList);
			}
			document.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
		// pipeline
		    
		// --- <<IS-END>> ---

                
	}



	public static final void propercaseFieldname (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(propercaseFieldname)>> ---
		// @sigtype java 3.5
		// [i] field:0:required input
		// [o] field:0:required output
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	input = IDataUtil.getString( pipelineCursor, "input" );
		
			if(input!=null){
				input = toTitleCase(input);
		
				}
		
			
		// pipeline
		
		IDataUtil.put( pipelineCursor, "output", input );
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	
	
	   private static Image topBanner = null;
	   private static Image bottomBanner = null;
	   private static String FILE = "";
	   
	   private static Color headerTextColor =  new Color(17, 123, 154);
	   private static Color sectionHeadColor = new Color(17, 123, 154);
	   private static Color labelColor = new Color(125, 125, 125);
	   private static Color tableHeadBg = new Color(17, 123, 154);
	   private static Color tableCellBg = new Color(226, 225, 222);
	   private static Color headBg = new Color(245, 245, 245);
	   private static Color tableContentColor =  new Color(17, 123, 154);
	   private static Color mainBg = new Color(238, 237, 233);
	   
	   
	   
	
	   private static Font redFont = new  Font(Font.HELVETICA, 7, Font.BOLD,headBg);
	
	   
	   
	   public static BaseFont getBaseFont() throws DocumentException, IOException
		{
			BaseFont baseFontJjar = BaseFont.createFont(fontJARpath,BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			return baseFontJjar;	
		}
	   
	   
	   static DateFormat df = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");
	   //private static String timeNow = df.format(Calendar.getInstance().getTime());
	   private static String timeNow="";
	   private static String briefActivityTtle = "";
	   private static String E2BBriefTitle ="";
	   private static String milestoneTrackr = "";
	   private static String path = "";
	   private static String activityId = "";
	   private static String PDF = "";
	   private static String sector = "";
	   private static String countryName ="";
	   private static String activityMileStoneTrackerStatus = "";
	   private static String countryMileStoneTrackerStatus = "";
	   private static String fontJARpath = "";
	   private static String actsource ="";
	   private static String brandLevel ="";
	   static class CustomDashedLineSeparator extends DottedLineSeparator {
	       protected float dash = 5;
	       protected float phase = 2.5f;
	   
	       public float getDash() {
	           return dash;
	       }
	   
	       public float getPhase() {
	           return phase;
	       }
	   
	       public void setDash(float dash) {
	           this.dash = dash;
	       }
	   
	       public void setPhase(float phase) {
	           this.phase = phase;
	       }
	   
	       public void draw(PdfContentByte canvas, float llx, float lly, float urx, float ury, float y) {
	           canvas.saveState();
	           canvas.setLineWidth((float) 1.0);
	           canvas.setLineDash(dash, gap, phase);
	           canvas.stroke();
	           drawLine(canvas, llx, urx, y);
	           canvas.restoreState();
	       }
	   }
	   
	   static class HeadFoot extends PdfPageEventHelper {
	       
	                    
	                    public void onStartPage(PdfWriter writer, Document document) {
	                                   
	                                    try {
	                                                   
	                                                    if (PDF.equalsIgnoreCase("activity")){
	                                                   
	                                                    topBanner.scaleToFit(document.getPageSize().getWidth(),document.getPageSize().getHeight());
	                                                                   topBanner.setAbsolutePosition(0, PageSize.A4.getHeight() - topBanner.getScaledHeight());
	                                                                   
	                                                                   document.add(topBanner);
	                                                                   
	                                                                /*  addHeader (document,briefActivityTtle,milestoneTrackr);*/
	                                                                   addHeader (document,E2BBriefTitle,milestoneTrackr);
	                                                   }
	                                                   else if (PDF.equalsIgnoreCase("country")){
	                                                                                                                                   
	                                                                    topBanner.scaleToFit(document.getPageSize().getWidth(),document.getPageSize().getHeight());
	                                                                                   topBanner.setAbsolutePosition(0, PageSize.A4.getHeight() - topBanner.getScaledHeight());
	                                                                                   
	                                                                                   document.add(topBanner);
	                                                                                   
	                                                                /*   addHeaderCountry(document,briefActivityTtle,activityMileStoneTrackerStatus,countryMileStoneTrackerStatus,countryName);*/
	                                                                   addHeaderCountry(document,E2BBriefTitle,activityMileStoneTrackerStatus,countryMileStoneTrackerStatus,countryName);
	                                                   }
	                                                   else if (PDF.equalsIgnoreCase("audit")){
	                                                       
	                                                       topBanner.scaleToFit(document.getPageSize().getWidth(),document.getPageSize().getHeight());
	                                                                      topBanner.setAbsolutePosition(0, PageSize.A4.getHeight() - topBanner.getScaledHeight());
	                                                                      
	                                                                      document.add(topBanner);
	                                                                      
	                                                     addHeaderCountry(document,null,"Audit Trail",null,null );
	                                      }
	                                                    
	                                   } catch (DocumentException e) {
	                                                   // TODO Auto-generated catch block
	                                                   e.printStackTrace();
	                                   }
	                                   
	                                                   
	                                    
	                    }
	                   
	           public void onEndPage(PdfWriter writer, Document document) {
	        	   
	        		BaseFont baseFontJjar = null;
		       		try {
		       			baseFontJjar = getBaseFont();
		       			
		       		} catch (IOException e) {
		       			// TODO Auto-generated catch block
		       			e.printStackTrace();
		       		} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	   
		       		Font catFont = new Font(baseFontJjar, 18,  Font.BOLD|Font.UNDERLINE,headerTextColor);
	        	   
	             
	        	   
	               PdfContentByte cb = writer.getDirectContent();
	               
	               
	               
	               
	               Phrase genetatedTime = new Phrase("Generated by JJAR on "+timeNow, redFont);
		           Phrase pageNo = new Phrase("Page "+document.getPageNumber()+" | Confidential", redFont);
	               
	               
	               //Phrase topActivityID = new Phrase(activityId, catFont);
	             
	               
	              /* ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
	                                  topActivityID,
	                      
	                                  (document.right() - document.left())  - document.leftMargin(),
	                       document.top()+5, 0); */
	                  
	               ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
		                    genetatedTime,
		                    (document.right() - document.left())  - document.leftMargin()*6,
		                    document.bottom() - 24, 0);	     
		            
		            
		            
		            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
		            		pageNo,
		                    (document.right() - document.left())  - document.leftMargin(),
		                    document.bottom() - 24, 0);
	           }
	       }
	   
	   private static void addHeader(Document document, String E2BBriefTitle,
	                                   String milestoneTrackr) throws DocumentException {
	                   
		   BaseFont baseFontJjar = null;
			try {
				baseFontJjar = getBaseFont();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   
			Font catFont = new Font(baseFontJjar, 18,  Font.BOLD|Font.UNDERLINE,headerTextColor);
			Font subcatFont = new Font(baseFontJjar, 11, Font.BOLD,headerTextColor);						
			Font milestoneFont = new Font(baseFontJjar, 18, Font.BOLD,Color.WHITE);           
		   
		   Paragraph preface = new Paragraph();
	                   
	                   float[] columnWidths = {1, 2, 1};
	                   
	                   PdfPTable table = new PdfPTable(columnWidths);
	                   
	                   addEmptytableRow(table,6,3);
	                   
	                  
	                   
	                   
	                   PdfPCell cell = new PdfPCell(new Phrase(""));
		           		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		           		cell.setPadding(4);
		           		cell.setBorder(0);
		           		table.addCell(cell);
	
		           		
		           		cell = new PdfPCell(new Phrase(activityId,catFont));
		           		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		           		cell.setPadding(4);
		           		cell.setBorder(0);
		           		table.addCell(cell);
		           		
		           		cell = new PdfPCell(new Phrase(""));
		           		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		           		cell.setPadding(4);
		           		cell.setBorder(0);
		           		table.addCell(cell);
	           		
	           		
	                   
	                   cell = new PdfPCell(new Phrase("",catFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                   cell.setPadding(4);
	                   cell.setBorder(0);
	                   table.addCell(cell);
	   
	                   
	                   cell = new PdfPCell(new Phrase(milestoneTrackr,milestoneFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                   cell.setPadding(2);
	                   cell.setPaddingBottom(6);
	                   cell.setBackgroundColor(headerTextColor);
	                   cell.setBorder(0);
	                   table.addCell(cell);
	                   
	                   cell = new PdfPCell(new Phrase("",catFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                   cell.setPadding(4);
	                   cell.setBorder(0);
	                   table.addCell(cell);
	                   
	                   addEmptytableRow(table,2,3);
	                   
	                   cell = new PdfPCell(new Phrase("",catFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                   cell.setPadding(4);
	                   cell.setBorder(0);
	                   table.addCell(cell);
	                   
	                   
	                   cell = new PdfPCell(new Phrase(E2BBriefTitle,subcatFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                   cell.setPadding(4);
	                   cell.setBorder(0);
	                   table.addCell(cell);
	                   
	                   cell = new PdfPCell(new Phrase("",catFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                   cell.setPadding(4);
	                   cell.setBorder(0);
	                   table.addCell(cell);
	                   
	                   
	                                                   
	                   table.setWidthPercentage(100);
	                   
	                   document.add(table);
	                   
	                   
	                   preface = new Paragraph();
	                   addEmptyLine(preface, 1);
	   
	                   document.add(preface);
	                   
	   }
	   
	   private static void addHeaderCountry(Document document, String E2BBriefTitle,
	                                   String activityMileStoneTrackerStatus,String countryMileStoneTrackerStatus,String countryName) throws DocumentException {
	   
	   
		   BaseFont baseFontJjar = null;
		   try {
		   	baseFontJjar = getBaseFont();
		   } catch (IOException e) {
		   	// TODO Auto-generated catch block
		   	e.printStackTrace();
		   }
						
		   countryName=activityId+" - "+countryName;
		   
	       Font milestoneFont = new Font(baseFontJjar, 18, Font.BOLD,Color.WHITE);
	       Font subcatFont = new Font(baseFontJjar, 11, Font.BOLD,headerTextColor);
	       Font catFont = new Font(baseFontJjar, 18,  Font.BOLD|Font.UNDERLINE,headerTextColor);
		   
	                   
	                   Paragraph preface = new Paragraph();
	                   
	                   float[] columnWidths = {1, 2, 1};
	                   
	                   PdfPTable table = new PdfPTable(columnWidths);
	                   
	                   addEmptytableRow(table,6,3);
	                   
	                   PdfPCell cell = new PdfPCell();
	                   if(countryMileStoneTrackerStatus!=null){
	                	   
	                   
		                   cell = new PdfPCell(new Phrase("",catFont));
		                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                   cell.setPadding(4);
		                   cell.setBorder(0);
		                   table.addCell(cell);
		   
		                  
		                   
		                   cell = new PdfPCell(new Phrase(countryMileStoneTrackerStatus,milestoneFont));
		                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                   cell.setPadding(2);
		                   cell.setPaddingBottom(6);
		                   cell.setBackgroundColor(headerTextColor);
		                   cell.setBorder(0);
		                   table.addCell(cell);
		                   
		                   cell = new PdfPCell(new Phrase("",catFont));
		                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                   cell.setPadding(4);
		                   cell.setBorder(0);
		                   table.addCell(cell);
		                   
		                   addEmptytableRow(table,2,3);
	                   }
	                   
	                   if(activityMileStoneTrackerStatus!=null){
		                   cell = new PdfPCell(new Phrase("",catFont));
		                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                   cell.setPadding(4);
		                   cell.setBorder(0);
		                   table.addCell(cell);
		   
		                   
		                   cell = new PdfPCell(new Phrase(activityMileStoneTrackerStatus,milestoneFont));
		                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                   cell.setPadding(2);
		                   cell.setPaddingBottom(6);
		                   cell.setBackgroundColor(headerTextColor);
		                   cell.setBorder(0);
		                   table.addCell(cell);
		                   
		                   cell = new PdfPCell(new Phrase("",catFont));
		                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                   cell.setPadding(4);
		                   cell.setBorder(0);
		                   table.addCell(cell);
		                   
		                   addEmptytableRow(table,2,3);
	                   }
	                   
	                   if(countryName!=null){
		                   cell = new PdfPCell(new Phrase("",catFont));
		                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                   cell.setPadding(4);
		                   cell.setBorder(0);
		                   table.addCell(cell);
		                   
		                   
		                   cell = new PdfPCell(new Phrase(countryName,subcatFont));
		                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                   cell.setPadding(4);
		                   cell.setBorder(0);
		                   table.addCell(cell);
		                   
		                   cell = new PdfPCell(new Phrase("",catFont));
		                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                   cell.setPadding(4);
		                   cell.setBorder(0);
		                   table.addCell(cell);
	                   }
	                   
	                                                   
	                   table.setWidthPercentage(100);
	                   
	                   document.add(table);
	                   
	                   
	                   preface = new Paragraph();
	                   addEmptyLine(preface, 1);
	   
	                   document.add(preface);
	   
	   }
	   
	   
	
	   
	   
	   private static void setupInfo(Document document, Map<String, String> mp) {
		   
		   BaseFont baseFontJjar = null;
			try {
				baseFontJjar = getBaseFont();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Font pageheaderFont = new Font(baseFontJjar, 14, Font.BOLD,sectionHeadColor);
			Font LabelFont = new Font(baseFontJjar, 8, Font.NORMAL,labelColor);
			Font tableContent = new Font(baseFontJjar, 8, Font.NORMAL,tableContentColor);
	       
	       
	                      try{
	                       
	                       Paragraph preface = new Paragraph();                                                                                    
	                       preface.setAlignment(Element.ALIGN_LEFT);      
	                       preface.setLeading(10);
	                       preface.add(new Paragraph("Creation Information", pageheaderFont));
	                       
	                       LineSeparator line = new LineSeparator();
	                       line.setLineColor(headerTextColor);
	                       preface.add(line);
	                       
	                       addEmptyLine(preface, 2);
	                       document.add(preface);               
	                       
	                       
	                       PdfPTable table = new PdfPTable(3);      
	                       
						   PdfPCell cell = new PdfPCell(new Phrase("Activity Id:",LabelFont));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
	                       
	                       cell = new PdfPCell(new Phrase("Sector:",LabelFont));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
	
	                       cell = new PdfPCell(new Phrase("Objective:",LabelFont));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   cell = new PdfPCell(new Phrase(mp.get("activityId"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
	                       
	                       cell = new PdfPCell(new Phrase(mp.get("sector"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
	
	                       cell = new PdfPCell(new Phrase(mp.get("objective"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
	
	                       addEmptytableRow(table,3,3);	
						   
						   
						   cell = new PdfPCell(new Phrase("Methodology:",LabelFont));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   cell = new PdfPCell(new Phrase("Sponsor Type:",LabelFont));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
	
	                       cell = new PdfPCell(new Phrase("Responsible Activity Manager:",LabelFont));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
	                       
	                       cell = new PdfPCell(new Phrase(mp.get("methodology"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   cell = new PdfPCell(new Phrase(mp.get("sponsorType"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
	
	                       cell = new PdfPCell(new Phrase(mp.get("ram"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
	
	                       addEmptytableRow(table,3,3);
						   
						   cell = new PdfPCell(new Phrase("Assigned Activity Manager:",LabelFont));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   cell = new PdfPCell(new Phrase("E2B Brief Title:",LabelFont));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
	                       
	                       cell = new PdfPCell(new Phrase("Activity Title:",LabelFont));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   cell = new PdfPCell(new Phrase(mp.get("aam"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						    cell = new PdfPCell(new Phrase(mp.get("E2BBriefTitle"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
	                       
	                      	
	                       cell = new PdfPCell(new Phrase(mp.get("activityTitle"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   addEmptytableRow(table,3,3);
						   
						   cell = new PdfPCell(new Phrase("Prospective/Retrospective:",LabelFont));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						    if (sector.equalsIgnoreCase("Consumer")){
	                           
	                           cell = new PdfPCell(new Phrase("Product Category:",LabelFont));}
	                      else
	                           {
	                           cell = new PdfPCell(new Phrase("Therapeutic Area:",LabelFont));}
	                       	                       
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
	
	                       cell = new PdfPCell(new Phrase("Responsible J&J Function:",LabelFont));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   cell = new PdfPCell(new Phrase(mp.get("prospective"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   cell = new PdfPCell(new Phrase(mp.get("TherapeuticArea"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
	
	                       cell = new PdfPCell(new Phrase(mp.get("responsibleJnJFunc"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   addEmptytableRow(table,3,3);
						   
						   cell = new PdfPCell(new Phrase("Data Collection Type:",LabelFont));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   cell = new PdfPCell(new Phrase("Interventional/Non-Interventional:",LabelFont));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   cell = new PdfPCell(new Phrase("Paused End Date:",LabelFont));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   cell = new PdfPCell(new Phrase(mp.get("dataCollctnTyp"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   cell = new PdfPCell(new Phrase(mp.get("interventional"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   cell = new PdfPCell(new Phrase(mp.get("pausedendDate"),tableContent));
	                       cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                       cell.setBorder(Rectangle.NO_BORDER);
	                       table.addCell(cell);
						   
						   addEmptytableRow(table,3,3);
	                       
	                       
	                       document.add(table);
	                       
	       } catch (DocumentException e) {
	                       // TODO Auto-generated catch block
	                       e.printStackTrace();
	       }
	       
	}
	   
	   private static void setupActivityInfo(Document document, Map<String, String> mp) {
		   
		   try {
	    	   
	    	   BaseFont baseFontJjar = null;
	       		try {
	       			baseFontJjar = getBaseFont();
	       		} catch (IOException e) {
	       			// TODO Auto-generated catch block
	       			e.printStackTrace();
	       		}
	                                                        
	                       
	       		Font pageheaderFont = new Font(baseFontJjar, 14, Font.BOLD,sectionHeadColor);
	       		Font LabelFont = new Font(baseFontJjar, 8, Font.NORMAL,labelColor);
	       		Font tableContent = new Font(baseFontJjar, 8, Font.NORMAL,tableContentColor);
	       		
	       		
	                   
	                   
	                                                                    
	                                   
	                                   
	                                   Paragraph preface = new Paragraph();                                                                                    
	                                   preface.setAlignment(Element.ALIGN_LEFT);      
	                                   preface.setLeading(10);
	                                   preface.add(new Paragraph("Activity Information", pageheaderFont));
	                                   
	                                   LineSeparator line = new LineSeparator();
	                                   line.setLineColor(headerTextColor);
	                                   preface.add(line);
	                                   
	                                   addEmptyLine(preface, 2);
	                                   document.add(preface);
	                                   
	                                   
	                                   PdfPTable table = new PdfPTable(3);                       
	                                   
	                       
	                                   PdfPCell cell = new PdfPCell(new Phrase("Activity Title:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("Objective:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("Methodology:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   
	                                   cell = new PdfPCell(new Phrase(mp.get("activityTitle"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase(mp.get("objective"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase(mp.get("methodology"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   
	                                   addEmptytableRow(table,3,3);
	                                   
	                                   cell = new PdfPCell(new Phrase("Assigned Activity Manager:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("Responsible Activity Manager:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("Sponsor Type:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   
	                                   cell = new PdfPCell(new Phrase(mp.get("aam"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase(mp.get("ram"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase(mp.get("sponsorType"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   addEmptytableRow(table,3,3);
	                                   
	                                   cell = new PdfPCell(new Phrase("Sector:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("Activity status:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("Activity Actual Start Date:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   
	                                   cell = new PdfPCell(new Phrase(mp.get("sector"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase(mp.get("activityStatus"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase(mp.get("actualActiitySrtDate"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   addEmptytableRow(table,3,3);
	                                   
	                                   cell = new PdfPCell(new Phrase("Activity Expected Start Date:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("E2B Brief Title",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   
	                                   cell = new PdfPCell(new Phrase(mp.get("expActivitySrtDate"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase(mp.get("E2BBriefTitle"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   addEmptytableRow(table,3,3);
	                                   document.add(table);
	                                   
	                   } catch (DocumentException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
	                   }
	                   
	   }
	   
	   
	   private static void countryInfo(Document document, Map<String, String> mp) {
	                   
	                   try {
	                	   
	                	   BaseFont baseFontJjar = null;
		               		try {
		               			baseFontJjar = getBaseFont();
		               		} catch (IOException e) {
		               			// TODO Auto-generated catch block
		               			e.printStackTrace();
		               		}
	                                                                    
	                                   
		               		Font pageheaderFont = new Font(baseFontJjar, 14, Font.BOLD,sectionHeadColor);
		               		Font LabelFont = new Font(baseFontJjar, 8, Font.NORMAL,labelColor);
		               		Font tableContent = new Font(baseFontJjar, 8, Font.NORMAL,tableContentColor);
		               		
	                                  
	                                   
	                                   Paragraph preface = new Paragraph();                                                                                    
	                                   preface.setAlignment(Element.ALIGN_LEFT);      
	                                   preface.setLeading(10);
	                                   preface.add(new Paragraph("Country Information", pageheaderFont));
	                                   
	                                   LineSeparator line = new LineSeparator();
	                                   line.setLineColor(headerTextColor);
	                                   preface.add(line);
	                                   
	                                   addEmptyLine(preface, 2);
	                                   document.add(preface);
	                                   
	                                   
	                                   
	                                   PdfPTable table = new PdfPTable(3);                       
	                                   
	                                   PdfPCell cell = new PdfPCell(new Phrase("Expected Start Date:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("Actual Start Date:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("Actual End Date:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   
	                                   cell = new PdfPCell(new Phrase(mp.get("expectedSrtDate"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase(mp.get("actualsrtDate"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase(mp.get("actualEnddate"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   
	                                  
	                                   addEmptytableRow(table,3,3);
	                                   
	                                   cell = new PdfPCell(new Phrase("Health Authority Approval Required:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   cell = new PdfPCell(new Phrase("IRB/IEC Approval Required:",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   cell = new PdfPCell(new Phrase("",LabelFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   
	                                   cell = new PdfPCell(new Phrase(mp.get("healthAuhorityApprovalReq"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   cell = new PdfPCell(new Phrase(mp.get("IRBIECApprovalRequired"),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBorder(Rectangle.NO_BORDER);
	                                   table.addCell(cell);
	                                   
	                                   document.add(table);
	                                   
	                   } catch (DocumentException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
	                   }
	                   
	   }
	   
	
	   
	     private static void setupInfoGeneralExecution(Document document, Map<String, String> mp, ArrayList<HashMap<String, String>> alternateActivityhmList) {
		                   
		                   try {
		                	   
		                	   
		                	   BaseFont baseFontJjar = null;
			               		try {
			               			baseFontJjar = getBaseFont();
			               		} catch (IOException e) {
			               			// TODO Auto-generated catch block
			               			e.printStackTrace();
			               		}
		                                                                    
		                                   
			               		Font pageheaderFont = new Font(baseFontJjar, 14, Font.BOLD,sectionHeadColor);
			               		Font LabelFont = new Font(baseFontJjar, 8, Font.NORMAL,labelColor);
			               		Font tableContent = new Font(baseFontJjar, 8, Font.NORMAL,tableContentColor);
			               		Font tableHeadFont = new Font(baseFontJjar, 8, Font.NORMAL,Color.WHITE);
		                	   
		                	   
		                	   
		                             
		                	   			   Paragraph preface = new Paragraph();                                                                                    
		                                   preface.setAlignment(Element.ALIGN_LEFT);      
		                                   preface.setLeading(10);
		                                   preface.add(new Paragraph("Identification - General Information", pageheaderFont));
		                                   
		                                   LineSeparator line = new LineSeparator();
		                                   line.setLineColor(headerTextColor);
		                                   preface.add(line);
		                                   
		                                   addEmptyLine(preface, 2);
		                                   document.add(preface);
		                                   
		                                   PdfPTable table = new PdfPTable(3);                       
		                                   PdfPCell cell;
		                                   
		                                  
		                                   cell = new PdfPCell(new Phrase("Activity Objectives:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("Sponsoring Company:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                	if (actsource.equalsIgnoreCase("Consumer HIVE")){
		                                   
		                                   cell = new PdfPCell(new Phrase("",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                	}
		                                   else{
		                                	  
		                                	   cell = new PdfPCell(new Phrase("Number of Required/Expected Participants/Patient Records:",LabelFont));
			                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                                   cell.setBorder(Rectangle.NO_BORDER);
			                                   table.addCell(cell);
		                                	   
		                                	   }
		                                   
		                                   
		                                   cell = new PdfPCell(new Phrase(mp.get("ActivityObjectives"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("SponsoringCompany"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   if (actsource.equalsIgnoreCase("Consumer HIVE")){
		                                   
		                                   cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   }
		                                   else {
		                                	   cell = new PdfPCell(new Phrase(mp.get("activityParticipantCount"),tableContent));
			                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                                   cell.setBorder(Rectangle.NO_BORDER);
			                                   table.addCell(cell);
		                                   }
		                                   
		                                   addEmptytableRow(table,3,3);
		                                   
		                                   cell = new PdfPCell(new Phrase("Does the activity involve an assessment of the safety/efficacy or effectiveness of a medicinal product or medical device?",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("Postmarketing Activity?",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("Eligible for PSMF?",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   
		                                   cell = new PdfPCell(new Phrase(mp.get("safetyEfficacyOfMedicinalProductOrMedicaldevice"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("postMarketing"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                	                                   
		                                   cell = new PdfPCell(new Phrase(mp.get("eligiblePSMF"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   addEmptytableRow(table,3,3);
		                                   
		                                   cell = new PdfPCell(new Phrase("Is the activity using online media to engage with participants?",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("Are the results of the activity planned to be published in a medical or scientific journal?",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("EudraCT Number:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   
		                                   cell = new PdfPCell(new Phrase(mp.get("onLineMedia"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("planToPublish"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("eudractNumber"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   addEmptytableRow(table,3,3);
		                                   
		                                   cell = new PdfPCell(new Phrase("Study Phase:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("Is this an FDA Regulated Intervention?",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("Are you keeping a database of non-serious adverse events?",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   
		                                   cell = new PdfPCell(new Phrase(mp.get("studyPhase"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("fdaRegulatedIntervention"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("dbOfNonSeriousAdverseEvents"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   addEmptytableRow(table,3,3);
		                                   
		                                   	if (actsource.equalsIgnoreCase("Consumer HIVE")){
		                                   	 
		                                   	   cell = new PdfPCell(new Phrase("",LabelFont));
			                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                                   cell.setBorder(Rectangle.NO_BORDER);
			                                   table.addCell(cell);
		                                   		
		                                   	}
		                                   	
		                                   	else {
		                                   		   cell = new PdfPCell(new Phrase("Will product be provided to participants to test?",LabelFont));
				                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				                                   cell.setBorder(Rectangle.NO_BORDER);
				                                   table.addCell(cell);
		                                   	}
		                                   
		   
		                                   cell = new PdfPCell(new Phrase("Feasibility Study?",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                 	                                   
		                                   cell = new PdfPCell(new Phrase("Document Location:",LabelFont));
			                               cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                               cell.setBorder(Rectangle.NO_BORDER);
			                               table.addCell(cell);
		                                   
			                           	if (actsource.equalsIgnoreCase("Consumer HIVE")){
			                           		
			                           		   cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
			                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                                   cell.setBorder(Rectangle.NO_BORDER);
			                                   table.addCell(cell);
			                           	}
			                           	else{
			                           		   cell = new PdfPCell(new Phrase(mp.get("productGivenToParticipants"),tableContent));
			                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			                                   cell.setBorder(Rectangle.NO_BORDER);
			                                   table.addCell(cell);
			                           	}
		                                   
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("feasibilityStudy"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("documentLocation"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                              
		                                   addEmptytableRow(table,3,3);
		                                   
		                                   cell = new PdfPCell(new Phrase("Blinding Type:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("Control Group Type:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   cell = new PdfPCell(new Phrase("Vulnerable Populations:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                                                   
		                                   
		                                   cell = new PdfPCell(new Phrase(mp.get("blindingType"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("controlGrpType"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   cell = new PdfPCell(new Phrase(mp.get("vulnerablePopulations"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   addEmptytableRow(table,3,3);
		                                   
		                                   cell = new PdfPCell(new Phrase("On Hold Reason:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("Stop Reason:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("Cancel reason:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   
		                                   cell = new PdfPCell(new Phrase(mp.get("onHoldReason"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("stoppedreason"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("cancelledReason"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   addEmptytableRow(table,3,3);
		                                   
		                                   cell = new PdfPCell(new Phrase("AE/PQC/SS Vendor Name:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("AE/PQC/SS Vendor Contact Name:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("AE/PQC/SS Vendor Contact Email:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   
		                                   cell = new PdfPCell(new Phrase(mp.get("ae_pqc_ssVendorName"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("ae_pqc_ssContactDetails"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("ae_pqc_ss_email"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   addEmptytableRow(table,3,3);
		
		                                   
		                                   cell = new PdfPCell(new Phrase("AE/PQC/SS Vendor Contact Phone:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("IND/IDE Indicator:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("IND/IDE Number:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   
		                                   cell = new PdfPCell(new Phrase(mp.get("ae_pqc_ss_cont"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("IND_IDE_Indicator"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get("IND_IDE_Number"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   addEmptytableRow(table,3,3);
		                                   
		                                   
		                                   cell = new PdfPCell(new Phrase("IND/IDE Grantor:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   
		                                   cell = new PdfPCell(new Phrase(mp.get("IND_IDE_Grantor"),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   addEmptytableRow(table,3,3);
		                                                                   
		                                   
		                                   cell = new PdfPCell(new Phrase("",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                  /* cell = new PdfPCell(new Phrase("Alternate Activity ID:",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);*/
		                                   
		                                   cell = new PdfPCell(new Phrase("",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   cell = new PdfPCell(new Phrase("",LabelFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBorder(Rectangle.NO_BORDER);
		                                   table.addCell(cell);
		                                   
		                                   addEmptytableRow(table,3,3);
		                                   
		                                   document.add(table);
		                                   		                                                                    
		                                   table = new PdfPTable(2);
		                                   
		                                   cell = new PdfPCell(new Phrase("Alternate Activity ID",tableHeadFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                                   cell.setBackgroundColor(tableHeadBg);
		                                   table.addCell(cell);
		   
		                                   cell = new PdfPCell(new Phrase("Alternate Activity ID Type",tableHeadFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                                   cell.setBackgroundColor(tableHeadBg);
		                                   table.addCell(cell);
		                                   
		                                   
		                                   table.setHeaderRows(1);
		                                   
		                                   
		                                                                     
		                                   if (alternateActivityhmList.size()>0){                                
		                                   for (int i = 0; i < alternateActivityhmList.size(); i++) {                                                  
		                                                   
		                                                   HashMap<String, String> country = alternateActivityhmList.get(i);                                     
		                                                   Color currentRowBg = mainBg;
		                                                   if(i%2!=0){
		                                                                   currentRowBg = tableCellBg;                                                                       
		                                                   }
		                                                   
		                                                   cell = new PdfPCell(new Phrase(country.get("id"),tableContent));
		                                                   cell.setBackgroundColor(currentRowBg);
		                                                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                                                   table.addCell(cell);
		                                                   
		                                                   cell = new PdfPCell(new Phrase(country.get("type"),tableContent));
		                                                   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                                                   cell.setBackgroundColor(currentRowBg);
		                                                   table.addCell(cell);
		                                   }
		                                   }
		                                   
		                                   else 
		                                   {
		                                                   
		                                                   addEmptytableRow(table,1,2);                                                  
		                                                   table.addCell(cell);
		                                                   
		                                   }
		                   
		                                   table.setWidthPercentage(79);
		                                   document.add(table);
		                                   document.newPage();
		                                   
		                                  // addEmptytableRow(table,3,3);
		                   
		                                   
		                                   preface = new Paragraph();                                                                                    
		                                   preface.setAlignment(Element.ALIGN_LEFT);      
		                                   preface.setLeading(10);
		                                   preface.add(new Paragraph("Identification - Pediatric Information", pageheaderFont));
		                                   
		                                   line = new LineSeparator();
		                                   line.setLineColor(headerTextColor);
		                                   preface.add(line);
		                                   
		                                   addEmptyLine(preface, 2);
		                                   document.add(preface);
		                                   
		                                 
		                                   table = new PdfPTable(3);                       
		                              
		                                   
		                                   cell = new PdfPCell(new Phrase("Does the activity involve a subject under 1 year old?",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase("Subject Age Range Minimum:",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase("Subject Age Range Maximum:",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   
		            	                   cell = new PdfPCell(new Phrase(mp.get("pedSubject1YrOld"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase(mp.get("pedMinAge"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase(mp.get("pedMaxAge"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   addEmptytableRow(table,5,3);
		                                   
		            	                   document.add(table);
		            	                   
		            	                   preface = new Paragraph();                                                                                    
		                                   preface.setAlignment(Element.ALIGN_LEFT);      
		                                   preface.setLeading(10);
		                                   preface.add(new Paragraph("Identification - Dates Information", pageheaderFont));
		                                   
		                                   line = new LineSeparator();
		                                   line.setLineColor(headerTextColor);
		                                   preface.add(line);
		                                   
		                                   addEmptyLine(preface, 2);
		                                   document.add(preface);
		                                   
		                                 
		                                   table = new PdfPTable(3);  
		                                   
		                                   cell = new PdfPCell(new Phrase("Expected Start Date:",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase("Actual Start Date:",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase("Expected End Date:",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   
		            	                   cell = new PdfPCell(new Phrase(mp.get("expectedStDt"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase(mp.get("acStDt"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase(mp.get("exEndDt"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   addEmptytableRow(table,3,3);
		            	                   
		            	                   cell = new PdfPCell(new Phrase("Actual End Date:",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase("Expected Primary Completion Date:",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase("Actual Primary Completion Date:",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   
		            	                   cell = new PdfPCell(new Phrase(mp.get("AcEndDt"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase(mp.get("expPrimaryCompDate"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase(mp.get("actualPrimaryCompDate"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   addEmptytableRow(table,3,3);
		            	                   document.add(table);
		                                   		                                   
		            	                   preface = new Paragraph();                                                                                    
		                                   preface.setAlignment(Element.ALIGN_LEFT);      
		                                   preface.setLeading(10);
		                                   preface.add(new Paragraph("Identification - Approved/Authorized Product Information", pageheaderFont));
		                                   
		                                   line = new LineSeparator();
		                                   line.setLineColor(headerTextColor);
		                                   preface.add(line);
		                                   
		                                   addEmptyLine(preface, 2);
		                                   document.add(preface);            	                   
		            	                   
		            	                   
		            	                   table = new PdfPTable(3);                            
		            	                   
		            	                   
		            	                   cell = new PdfPCell(new Phrase("Health Outcomes Study?",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase("Health Economics Study?",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase("Epidemiology Study?",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   
		            	                   
		            	                   
		            	                   cell = new PdfPCell(new Phrase(mp.get("healthOutcomesStd"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase(mp.get("healthEcoStd"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase(mp.get("epidemiologyStd"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   
		            	                   
		            	                   addEmptytableRow(table,3,3);
		            	                   
		            	                   cell = new PdfPCell(new Phrase("Drug Utilization Study?",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   
		            	                   cell = new PdfPCell(new Phrase(""));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   cell = new PdfPCell(new Phrase(""));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   
		            	                   
		            	                   cell = new PdfPCell(new Phrase(mp.get("drugUtiStd"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   
		            	                   
		            	                   addEmptytableRow(table,5,3);
		            	                   
		            	                   document.add(table);
		            	                   
		            	                   preface = new Paragraph();                                                                                    
		                                   preface.setAlignment(Element.ALIGN_LEFT);      
		                                   preface.setLeading(10);
		                                   preface.add(new Paragraph("Identification - Postmarketing Information", pageheaderFont));
		                                   
		                                   line = new LineSeparator();
		                                   line.setLineColor(headerTextColor);
		                                   preface.add(line);
		                                   
		                                   addEmptyLine(preface, 2);
		                                   document.add(preface);            	                   
		            	                   
		            	                   
		            	                   table = new PdfPTable(3);  
		            	                   
		            	                   cell = new PdfPCell(new Phrase("Postmarketing Main Objective:",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase("Post Authorization Safety Study (PASS):",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase("PMC Applicable Authorities:",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   
		            	                   
		            	                   
		            	                   cell = new PdfPCell(new Phrase(mp.get("mainObj"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase(mp.get("pass"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	   
		            	                   cell = new PdfPCell(new Phrase(mp.get("appAuth"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   addEmptytableRow(table,3,3);
		            	                   
		            	                   //table = new PdfPTable(3); 
		            	                   
		            	                   cell = new PdfPCell(new Phrase("Is this a Health Authority required/imposed/mandated Post-marketing Commitment (PMC) or a voluntary Post-marketing study that the MAH has agreed to conduct?",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   cell = new PdfPCell(new Phrase("",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   cell = new PdfPCell(new Phrase("",LabelFont));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   
		            	                   cell = new PdfPCell(new Phrase(mp.get("comIndicator"),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
		            	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		            	                   cell.setBorder(Rectangle.NO_BORDER);
		            	                   table.addCell(cell);
		            	                   
		            	                   document.add(table);
		            	                   
		                                   
		                   }     catch (DocumentException e) {
		                                   // TODO Auto-generated catch block
		                                   e.printStackTrace();
		                   }
		                   
		   }                
	                   
	      
	     private static void setupInfoGeneralExecutionPharma(Document document, Map<String, String> mp, ArrayList<HashMap<String, String>> alternateActivityhmList) {
	         
	         try {
	                 
	        	 BaseFont baseFontJjar = null;
	        		try {
	        			baseFontJjar = getBaseFont();
	        		} catch (IOException e) {
	        			// TODO Auto-generated catch block
	        			e.printStackTrace();
	        		}
	                                                         
	                        
	        		Font pageheaderFont = new Font(baseFontJjar, 14, Font.BOLD,sectionHeadColor);
	        		Font LabelFont = new Font(baseFontJjar, 8, Font.NORMAL,labelColor);
	        		Font tableContent = new Font(baseFontJjar, 8, Font.NORMAL,tableContentColor);
	        		Font tableHeadFont = new Font(baseFontJjar, 8, Font.NORMAL,Color.WHITE);
	     	   
	     	   
	        	 
	        	 
	      	   			   Paragraph preface = new Paragraph();                                                                                    
	                         preface.setAlignment(Element.ALIGN_LEFT);      
	                         preface.setLeading(10);
	                         preface.add(new Paragraph("Identification - General Information", pageheaderFont));
	                         
	                         LineSeparator line = new LineSeparator();
	                         line.setLineColor(headerTextColor);
	                         preface.add(line);
	                         
	                         addEmptyLine(preface, 2);
	                         document.add(preface);
	                         
	                         PdfPTable table = new PdfPTable(3);                       
	                         PdfPCell cell;
	                         
	                        
	                         cell = new PdfPCell(new Phrase("Activity Objectives:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("Sponsoring Company:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         if (actsource.equalsIgnoreCase("Pharma HIVE")){
	                        	 cell = new PdfPCell(new Phrase("",LabelFont));
		                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                         cell.setBorder(Rectangle.NO_BORDER);
		                         table.addCell(cell);
	                         }
	                         else{
	                        	 cell = new PdfPCell(new Phrase("Number of Required/Expected Participants/Patient Records:",LabelFont));
		                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                         cell.setBorder(Rectangle.NO_BORDER);
		                         table.addCell(cell);
	                         }
	                         
	                         cell = new PdfPCell(new Phrase(mp.get("ActivityObjectives"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("SponsoringCompany"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         if (actsource.equalsIgnoreCase("Pharma HIVE")){
	                         
	                         cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         }
	                         else{
	                        	 cell = new PdfPCell(new Phrase(mp.get("activityParticipantCount"),tableContent));
		                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                         cell.setBorder(Rectangle.NO_BORDER);
		                         table.addCell(cell);
	                         }
	                         
	                         addEmptytableRow(table,3,3);
	                         
	                         cell = new PdfPCell(new Phrase("Does the activity involve an assessment of the safety/efficacy or effectiveness of a medicinal product or medical device?",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("Postmarketing Activity?",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         if (actsource.equalsIgnoreCase("iAWARE"))
	                        		 {
	                         cell = new PdfPCell(new Phrase("Primary Indication Under Study",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         }
	                         else{
	                         cell = new PdfPCell(new Phrase("",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         }
	                         
	                         cell = new PdfPCell(new Phrase(mp.get("safetyEfficacyOfMedicinalProductOrMedicaldevice"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("postMarketing"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         if (actsource.equalsIgnoreCase("iAWARE"))
	                		 {                                  
	                         cell = new PdfPCell(new Phrase(mp.get("primaryIndicationUnderStudy"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                		 }
	                         else{
	                        	 cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
		                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                         cell.setBorder(Rectangle.NO_BORDER);
		                         table.addCell(cell); 
	                         }
	                         addEmptytableRow(table,3,3);
	                         
	                         cell = new PdfPCell(new Phrase("Is the activity using online media to engage with participants?",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("Are the results of the activity planned to be published in a medical or scientific journal?",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("EudraCT Number:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         
	                         cell = new PdfPCell(new Phrase(mp.get("onLineMedia"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("planToPublish"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("eudractNumber"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         addEmptytableRow(table,3,3);
	                         
	                         cell = new PdfPCell(new Phrase("Study Phase:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("Are you keeping a database of non-serious adverse events?",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("Does the Activity Allow the Inclusion of Healthy Volunteers?",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         
	                         cell = new PdfPCell(new Phrase(mp.get("studyPhase"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("dbOfNonSeriousAdverseEvents"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("acceptHealthyVolunteers"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         addEmptytableRow(table,3,3);
	                         
	                                                      
	                         cell = new PdfPCell(new Phrase("Is the Activity Associated with a Safety Review Plan?",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("Actual First Patient First Visit Date:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("Is the Activity Looking at Aggregate Participant Data?",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         
	                         cell = new PdfPCell(new Phrase(mp.get("safetyReviewPlan"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("actual1stPatient1stVisitDate"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("aggregateParticipantDate"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         addEmptytableRow(table,3,3);
	                         
	                         
	                         cell = new PdfPCell(new Phrase("Is the Activity Designed to Update the Label?",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("Spontaneous/Solicited AE Reporting:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("Document Location:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         
	                         cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("aeReporting"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         addEmptytableRow(table,3,3);
	                         
	                         cell = new PdfPCell(new Phrase("Blinding Type:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("Control Group Type:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         cell = new PdfPCell(new Phrase("Vulnerable Populations:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                                                         
	                         
	                         cell = new PdfPCell(new Phrase(mp.get("blindingType"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("controlGrpType"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         cell = new PdfPCell(new Phrase(mp.get("vulnerablePopulations"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         addEmptytableRow(table,3,3);
	                         
	                         cell = new PdfPCell(new Phrase("On Hold Reason:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("Stopped Reason:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("Cancelled reason:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         
	                         cell = new PdfPCell(new Phrase(mp.get("onHoldReason"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("stoppedreason"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("cancelledReason"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         addEmptytableRow(table,3,3);
	                         
	                         cell = new PdfPCell(new Phrase("AE/PQC/SS Vendor Name:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("AE/PQC/SS Vendor Contact Name:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("AE/PQC/SS Vendor Contact Email:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         
	                         cell = new PdfPCell(new Phrase(mp.get("ae_pqc_ssVendorName"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("ae_pqc_ssContactDetails"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("ae_pqc_ss_email"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         addEmptytableRow(table,3,3);
	
	                         
	                         cell = new PdfPCell(new Phrase("AE/PQC/SS Vendor Contact Phone:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("IND/IDE Indicator:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("IND/IDE Number:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         
	                         cell = new PdfPCell(new Phrase(mp.get("ae_pqc_ss_cont"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("IND_IDE_Indicator"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("IND_IDE_Number"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         addEmptytableRow(table,3,3);
	                         
	                         
	                         cell = new PdfPCell(new Phrase("IND/IDE Grantor:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("Medically Important Results Assessment Required?",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         
	                         cell = new PdfPCell(new Phrase(mp.get("IND_IDE_Grantor"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get("mira"),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         addEmptytableRow(table,3,3);
	                                                         
	                         
	                        /* cell = new PdfPCell(new Phrase("Alternate Activity ID:",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);*/
	                         
	                         cell = new PdfPCell(new Phrase("",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         cell = new PdfPCell(new Phrase("",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         cell = new PdfPCell(new Phrase("",LabelFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                         cell.setBorder(Rectangle.NO_BORDER);
	                         table.addCell(cell);
	                         
	                         addEmptytableRow(table,3,3);
	                         
	                         document.add(table);
	                         		                                                                    
	                         table = new PdfPTable(2);
	                         
	                         cell = new PdfPCell(new Phrase("Alternate Activity ID",tableHeadFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                         cell.setBackgroundColor(tableHeadBg);
	                         table.addCell(cell);
	
	                         cell = new PdfPCell(new Phrase("Alternate Activity ID Type",tableHeadFont));
	                         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                         cell.setBackgroundColor(tableHeadBg);
	                         table.addCell(cell);
	                         
	                         
	                         table.setHeaderRows(1);
	                         
	                         
	                                                           
	                         if (alternateActivityhmList.size()>0){                                
	                         for (int i = 0; i < alternateActivityhmList.size(); i++) {                                                  
	                                         
	                                         HashMap<String, String> country = alternateActivityhmList.get(i);                                     
	                                         Color currentRowBg = mainBg;
	                                         if(i%2!=0){
	                                                         currentRowBg = tableCellBg;                                                                       
	                                         }
	                                         
	                                         cell = new PdfPCell(new Phrase(country.get("id"),tableContent));
	                                         cell.setBackgroundColor(currentRowBg);
	                                         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                                         table.addCell(cell);
	                                         
	                                         cell = new PdfPCell(new Phrase(country.get("type"),tableContent));
	                                         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                                         cell.setBackgroundColor(currentRowBg);
	                                         table.addCell(cell);
	                         }
	                         }
	                         
	                         else 
	                         {
	                                         
	                                         addEmptytableRow(table,1,2);                                                  
	                                         table.addCell(cell);
	                                         
	                         }
	         
	                         table.setWidthPercentage(79);
	                         document.add(table);
	                         document.newPage();
	                         
	                        // addEmptytableRow(table,3,3);
	         
	                         
	                         preface = new Paragraph();                                                                                    
	                         preface.setAlignment(Element.ALIGN_LEFT);      
	                         preface.setLeading(10);
	                         preface.add(new Paragraph("Identification - Pediatric Information", pageheaderFont));
	                         
	                         line = new LineSeparator();
	                         line.setLineColor(headerTextColor);
	                         preface.add(line);
	                         
	                         addEmptyLine(preface, 2);
	                         document.add(preface);
	                         
	                       
	                         table = new PdfPTable(3);                       
	                    
	                         
	                         cell = new PdfPCell(new Phrase("Does the activity involve a subject under 1 year old?",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase("Subject Age Range Minimum:",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase("Subject Age Range Maximum:",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   
	  	                   cell = new PdfPCell(new Phrase(mp.get("pedSubject1YrOld"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase(mp.get("pedMinAge"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase(mp.get("pedMaxAge"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   addEmptytableRow(table,5,3);
	                         
	  	                   document.add(table);
	  	                   
	  	                   preface = new Paragraph();                                                                                    
	                         preface.setAlignment(Element.ALIGN_LEFT);      
	                         preface.setLeading(10);
	                         preface.add(new Paragraph("Identification - Dates Information", pageheaderFont));
	                         
	                         line = new LineSeparator();
	                         line.setLineColor(headerTextColor);
	                         preface.add(line);
	                         
	                         addEmptyLine(preface, 2);
	                         document.add(preface);
	                         
	                       
	                         table = new PdfPTable(3);  
	                         
	                         cell = new PdfPCell(new Phrase("Expected Start Date:",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase("Actual Start Date:",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase("Expected End Date:",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   
	  	                   cell = new PdfPCell(new Phrase(mp.get("expectedStDt"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase(mp.get("acStDt"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase(mp.get("exEndDt"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   addEmptytableRow(table,3,3);
	  	                   
	  	                   cell = new PdfPCell(new Phrase("Actual End Date:",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase("Expected Primary Completion Date:",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase("Actual Primary Completion Date:",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   
	  	                   cell = new PdfPCell(new Phrase(mp.get("AcEndDt"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase(mp.get("expPrimaryCompDate"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase(mp.get("actualPrimaryCompDate"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   addEmptytableRow(table,3,3);
	  	                   document.add(table);
	                         		                                   
	  	                   preface = new Paragraph();                                                                                    
	                         preface.setAlignment(Element.ALIGN_LEFT);      
	                         preface.setLeading(10);
	                         preface.add(new Paragraph("Identification - Approved/Authorized Product Information", pageheaderFont));
	                         
	                         line = new LineSeparator();
	                         line.setLineColor(headerTextColor);
	                         preface.add(line);
	                         
	                         addEmptyLine(preface, 2);
	                         document.add(preface);            	                   
	  	                   
	  	                   
	  	                   table = new PdfPTable(3);                            
	  	                   
	  	                   
	  	                   cell = new PdfPCell(new Phrase("Health Outcomes Study?",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase("Health Economics Study?",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase("Epidemiology Study?",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   
	  	                   
	  	                   
	  	                   cell = new PdfPCell(new Phrase(mp.get("healthOutcomesStd"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase(mp.get("healthEcoStd"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase(mp.get("epidemiologyStd"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   
	  	                   
	  	                   addEmptytableRow(table,3,3);
	  	                   
	  	                   cell = new PdfPCell(new Phrase("Drug Utilization Study?",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   
	  	                   cell = new PdfPCell(new Phrase(""));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   cell = new PdfPCell(new Phrase(""));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   
	  	                   
	  	                   cell = new PdfPCell(new Phrase(mp.get("drugUtiStd"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   
	  	                   
	  	                   addEmptytableRow(table,5,3);
	  	                   
	  	                   document.add(table);
	  	                   
	  	                   preface = new Paragraph();                                                                                    
	                         preface.setAlignment(Element.ALIGN_LEFT);      
	                         preface.setLeading(10);
	                         preface.add(new Paragraph("Identification - Postmarketing Information", pageheaderFont));
	                         
	                         line = new LineSeparator();
	                         line.setLineColor(headerTextColor);
	                         preface.add(line);
	                         
	                         addEmptyLine(preface, 2);
	                         document.add(preface);            	                   
	  	                   
	  	                   
	  	                   table = new PdfPTable(3);  
	  	                   
	  	                   cell = new PdfPCell(new Phrase("Postmarketing Main Objective:",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase("Post Authorization Safety Study (PASS):",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase("PMC Applicable Authorities:",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   
	  	                   
	  	                   
	  	                   cell = new PdfPCell(new Phrase(mp.get("mainObj"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase(mp.get("pass"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	   
	  	                   cell = new PdfPCell(new Phrase(mp.get("appAuth"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   addEmptytableRow(table,3,3);
	  	                   
	  	                   //table = new PdfPTable(3); 
	  	                   
	  	                   cell = new PdfPCell(new Phrase("Is this a Health Authority required/imposed/mandated Post-marketing Commitment (PMC) or a voluntary Post-marketing study that the MAH has agreed to conduct?",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                  /* cell = new PdfPCell(new Phrase("",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   */
	  	                 /*  cell = new PdfPCell(new Phrase("Medically Important Results Assessment Required?",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);*/
	  	                   
	  	                   cell = new PdfPCell(new Phrase("",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   cell = new PdfPCell(new Phrase("",LabelFont));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   
	  	                   cell = new PdfPCell(new Phrase(mp.get("comIndicator"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                  /* cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);*/
	  	                   
	  	                 /*  cell = new PdfPCell(new Phrase(mp.get("mira"),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);*/
	  	                   
	  	                   cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
	  	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  	                   cell.setBorder(Rectangle.NO_BORDER);
	  	                   table.addCell(cell);
	  	                   
	  	                   document.add(table);
	  	                   
	                         
	         }     catch (DocumentException e) {
	                         // TODO Auto-generated catch block
	                             e.printStackTrace();
	             }
	             
	}     
		     
		   
		   private static void setupInfoCountries(Document document,ArrayList<HashMap<String, String>> countryList)
		                                   throws BadElementException {
		                   
		   
		                   try {
		                              
		                	   
		                	   BaseFont baseFontJjar = null;
			               		try {
			               			baseFontJjar = getBaseFont();
			               		} catch (IOException e) {
			               			// TODO Auto-generated catch block
			               			e.printStackTrace();
			               		}
		                                                                    
		                                   
			               		Font pageheaderFont = new Font(baseFontJjar, 14, Font.BOLD,sectionHeadColor);		               		
			               		Font tableContent = new Font(baseFontJjar, 8, Font.NORMAL,tableContentColor);
			               		Font tableHeadFont = new Font(baseFontJjar, 8, Font.NORMAL,Color.WHITE);
		                	   
		                                   /************ Page Heading Starts*************/
	                                   
	                                                   
	                                  
	                                   
	                                   Paragraph preface = new Paragraph();                                                                                    
	                                   preface.setAlignment(Element.ALIGN_LEFT);      
	                                   preface.setLeading(10);
	                                   preface.add(new Paragraph("Countries", pageheaderFont));
	                                   
	                                   LineSeparator line = new LineSeparator();
	                                   line.setLineColor(headerTextColor);
	                                   preface.add(line);
	                                   
	                                   addEmptyLine(preface, 2);
	                                   document.add(preface);
	                                   
	                                   /************ Page Heading Ends*************/
	                                   
	                                   PdfPTable table = new PdfPTable(5);                       
	                                   
	                       
	                                   PdfPCell cell = new PdfPCell(new Phrase("Country",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("Expected Start Date",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("Actual Start Date",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	                                   
	                                   cell = new PdfPCell(new Phrase("Actual End Date",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	                                   
	                                   cell = new PdfPCell(new Phrase("Status",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);          
	                                                                                                                                   
	                                   table.setHeaderRows(1);
	                                   
	                                   if (countryList.size()>0){                                
	                                   for (int i = 0; i < countryList.size(); i++) {                                                  
	                                                   
	                                                   HashMap<String, String> country = countryList.get(i);                                     
	                                                   Color currentRowBg = mainBg;
	                                                   if(i%2!=0){
	                                                                   currentRowBg = tableCellBg;                                                                       
	                                                   }
	                                                   
	                                                   cell = new PdfPCell(new Phrase(country.get("countryName"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                   
	                                                   cell = new PdfPCell(new Phrase(country.get("expStDt"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                   
	                                                
	                                                   
	                                                   cell = new PdfPCell(new Phrase(country.get("actualStDt"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                   
	                                                   cell = new PdfPCell(new Phrase(country.get("actualEndDt"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                   
	                                                   cell = new PdfPCell(new Phrase(country.get("status"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                                                                                   
	                                   }
	                                   }
	                                   else 
	                                   {
	                                                   
	                                                   addEmptytableRow(table,1,5);                                                  
	                                                   table.addCell(cell);
	                                                   
	                                   }
	                   
	                                   table.setWidthPercentage(100);
	                                   document.add(table);
	                                   
	                                   
	                   } catch (DocumentException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
	                   }
	   
	   }
	   
	   
	   private static void productInfo(Document document,ArrayList<HashMap<String, String>> productList)
	                                   throws BadElementException {
	      //  if ((actsource.equalsIgnoreCase("HIVE")) && (brandLevel.equalsIgnoreCase("brand"))) {           
		   if ((actsource.equalsIgnoreCase("Consumer HIVE")) && (brandLevel.equalsIgnoreCase("brand"))) {
			   
			   try {
	        	   
	        	   BaseFont baseFontJjar = null;
	           		try {
	           			baseFontJjar = getBaseFont();
	           		} catch (IOException e) {
	           			// TODO Auto-generated catch block
	           			e.printStackTrace();
	           		}
	                                                            
	                           
	           		Font pageheaderFont = new Font(baseFontJjar, 14, Font.BOLD,sectionHeadColor);		               		
	           		Font tableContent = new Font(baseFontJjar, 8, Font.NORMAL,tableContentColor);
	           		Font tableHeadFont = new Font(baseFontJjar, 8, Font.NORMAL,Color.WHITE);
	           		
	           		
	                           
	                           /************ Page Heading Starts*************/
	                           
	                           Paragraph preface = new Paragraph();                                                                                    
	                           preface.setAlignment(Element.ALIGN_LEFT);      
	                           preface.setLeading(10);
	                           preface.add(new Paragraph("Products", pageheaderFont));
	                           
	                           LineSeparator line = new LineSeparator();
	                           line.setLineColor(headerTextColor);
	                           preface.add(line);
	                           
	                           addEmptyLine(preface, 2);
	                           document.add(preface);
	                           
	                           /************ Page Heading Ends*************/
	                           
	                           PdfPTable table = new PdfPTable(8);                       
	                                             
	                           PdfPCell cell = new PdfPCell(new Phrase("Product Source System",tableHeadFont));
	                           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                           cell.setBackgroundColor(tableHeadBg);
	                           table.addCell(cell);
	                           
	                           cell = new PdfPCell(new Phrase("Brand Name",tableHeadFont));
	                           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                           cell.setBackgroundColor(tableHeadBg);
	                           table.addCell(cell);
	                           
	                           cell = new PdfPCell(new Phrase("Product Trade Name",tableHeadFont));
	                           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                           cell.setBackgroundColor(tableHeadBg);
	                           table.addCell(cell);
	                           	
	                           if (sector.equalsIgnoreCase("Consumer"))
	                           {
	                           cell = new PdfPCell(new Phrase("Active Ingredients",tableHeadFont));
	                           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                           cell.setBackgroundColor(tableHeadBg);
	                           table.addCell(cell);
	                           }
	                           else{
	                        	   cell = new PdfPCell(new Phrase("Generic Ingredients",tableHeadFont));
	                               cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                               cell.setBackgroundColor(tableHeadBg);
	                               table.addCell(cell);
	                           }
	
	                           cell = new PdfPCell(new Phrase("Dosage Form",tableHeadFont));
	                           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                           cell.setBackgroundColor(tableHeadBg);
	                           table.addCell(cell);
	                           
	                           cell = new PdfPCell(new Phrase("Strength",tableHeadFont));
	                           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                           cell.setBackgroundColor(tableHeadBg);
	                           table.addCell(cell);
	                           
	                        
	                           
	                           cell = new PdfPCell(new Phrase("Product Route Of Administration",tableHeadFont));
	                           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                           cell.setBackgroundColor(tableHeadBg);
	                           table.addCell(cell);
	                           
	                           cell = new PdfPCell(new Phrase("Country",tableHeadFont));
	                           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                           cell.setBackgroundColor(tableHeadBg);
	                           table.addCell(cell);
	                                                                                                                           
	                           table.setHeaderRows(1);
	                           
	                           if (productList.size()>0){                                
	                           for (int i = 0; i < productList.size(); i++) {                                                 
	                                           
	                                           HashMap<String, String> product = productList.get(i);                                     
	                                           Color currentRowBg = mainBg;
	                                           if(i%2!=0){
	                                                           currentRowBg = tableCellBg;                                                                       
	                                           }
	                                           
	                                           cell = new PdfPCell(new Phrase(product.get("source"),tableContent));
	                                           cell.setBackgroundColor(currentRowBg);
	                                           table.addCell(cell);
	                                           
	                                           cell = new PdfPCell(new Phrase(product.get("brandName"),tableContent));
	                                           cell.setBackgroundColor(currentRowBg);
	                                           table.addCell(cell);
	                                           
	                                           cell = new PdfPCell(new Phrase(product.get("productTradeName"),tableContent));
	                                           cell.setBackgroundColor(currentRowBg);
	                                           table.addCell(cell);
	                                           
	                                           cell = new PdfPCell(new Phrase(product.get("activeIngredient"),tableContent));
	                                           cell.setBackgroundColor(currentRowBg);
	                                           table.addCell(cell);
	                                           
	                                           cell = new PdfPCell(new Phrase(product.get("dosageForm"),tableContent));
	                                           cell.setBackgroundColor(currentRowBg);
	                                           table.addCell(cell);
	                                           
	                                           cell = new PdfPCell(new Phrase(product.get("strength"),tableContent));
	                                           cell.setBackgroundColor(currentRowBg);
	                                           table.addCell(cell);
	                                           
	                                       
	                                           cell = new PdfPCell(new Phrase(product.get("productRoute"),tableContent));
	                                           cell.setBackgroundColor(currentRowBg);
	                                           table.addCell(cell);
	                                           
	                                           cell = new PdfPCell(new Phrase(product.get("country"),tableContent));
	                                           cell.setBackgroundColor(currentRowBg);
	                                           table.addCell(cell);
	                                                                                                           
	                           }
	                           }
	                           else 
	                           {
	                                           
	                                           addEmptytableRow(table,1,8);                                                  
	                                           table.addCell(cell);
	                                           
	                           }
	           
	                           table.setWidthPercentage(100);
	                           document.add(table);
	                           
	                           
	           } catch (DocumentException e) {
	                           // TODO Auto-generated catch block
	                           e.printStackTrace();
	           }
			   
		   }
		   else {
	   
	                   try {
	                	   
	                	   BaseFont baseFontJjar = null;
		               		try {
		               			baseFontJjar = getBaseFont();
		               		} catch (IOException e) {
		               			// TODO Auto-generated catch block
		               			e.printStackTrace();
		               		}
	                                                                    
	                                   
		               		Font pageheaderFont = new Font(baseFontJjar, 14, Font.BOLD,sectionHeadColor);		               		
		               		Font tableContent = new Font(baseFontJjar, 8, Font.NORMAL,tableContentColor);
		               		Font tableHeadFont = new Font(baseFontJjar, 8, Font.NORMAL,Color.WHITE);
		               		
		               		
	                                   
	                                   /************ Page Heading Starts*************/
	                                   
	                                   Paragraph preface = new Paragraph();                                                                                    
	                                   preface.setAlignment(Element.ALIGN_LEFT);      
	                                   preface.setLeading(10);
	                                   preface.add(new Paragraph("Products", pageheaderFont));
	                                   
	                                   LineSeparator line = new LineSeparator();
	                                   line.setLineColor(headerTextColor);
	                                   preface.add(line);
	                                   
	                                   addEmptyLine(preface, 2);
	                                   document.add(preface);
	                                   
	                                   /************ Page Heading Ends*************/
	                                   
	                                   PdfPTable table = new PdfPTable(7);                       
	                                   
	                       
	                                   PdfPCell cell = new PdfPCell(new Phrase("Product Source System",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	                                   
	                                   cell = new PdfPCell(new Phrase("Product Trade Name",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	                                   	
	                                   if (sector.equalsIgnoreCase("Consumer"))
	                                   {
	                                   cell = new PdfPCell(new Phrase("Active Ingredients",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	                                   }
	                                   else{
	                                	   cell = new PdfPCell(new Phrase("Generic Ingredients",tableHeadFont));
		                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                                   cell.setBackgroundColor(tableHeadBg);
		                                   table.addCell(cell);
	                                   }
	   
	                                   cell = new PdfPCell(new Phrase("Dosage Form",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	                                   
	                                   cell = new PdfPCell(new Phrase("Strength",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	                                   
	                                
	                                   
	                                   cell = new PdfPCell(new Phrase("Product Route Of Administration",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	                                   
	                                   cell = new PdfPCell(new Phrase("Country",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	                                                                                                                                   
	                                   table.setHeaderRows(1);
	                                   
	                                   if (productList.size()>0){                                
	                                   for (int i = 0; i < productList.size(); i++) {                                                 
	                                                   
	                                                   HashMap<String, String> product = productList.get(i);                                     
	                                                   Color currentRowBg = mainBg;
	                                                   if(i%2!=0){
	                                                                   currentRowBg = tableCellBg;                                                                       
	                                                   }
	                                                   
	                                                   cell = new PdfPCell(new Phrase(product.get("source"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                   
	                                                   cell = new PdfPCell(new Phrase(product.get("productTradeName"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                   
	                                                   cell = new PdfPCell(new Phrase(product.get("activeIngredient"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                   
	                                                   cell = new PdfPCell(new Phrase(product.get("dosageForm"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                   
	                                                   cell = new PdfPCell(new Phrase(product.get("strength"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                   
	                                               
	                                                   cell = new PdfPCell(new Phrase(product.get("productRoute"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                   
	                                                   cell = new PdfPCell(new Phrase(product.get("country"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                                                                                   
	                                   }
	                                   }
	                                   else 
	                                   {
	                                                   
	                                                   addEmptytableRow(table,1,7);                                                  
	                                                   table.addCell(cell);
	                                                   
	                                   }
	                   
	                                   table.setWidthPercentage(100);
	                                   document.add(table);
	                                   
	                                   
	                   } catch (DocumentException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
	                   }
		   }
	   
	   }
	   
	   
	   private static void productInfo_pharma(Document document,ArrayList<HashMap<String, String>> phrmaproductList)
	           throws BadElementException {
	
	
	try {
		
		  BaseFont baseFontJjar = null;
	 		try {
	 			baseFontJjar = getBaseFont();
	 		} catch (IOException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	                                                  
	                 
	 		Font pageheaderFont = new Font(baseFontJjar, 14, Font.BOLD,sectionHeadColor);		               		
	 		Font tableContent = new Font(baseFontJjar, 8, Font.NORMAL,tableContentColor);
	 		Font tableHeadFont = new Font(baseFontJjar, 8, Font.NORMAL,Color.WHITE);
	 		
	 		
		
	           
	           /************ Page Heading Starts*************/
	           
	           Paragraph preface = new Paragraph();                                                                                    
	           preface.setAlignment(Element.ALIGN_LEFT);      
	           preface.setLeading(10);
	           preface.add(new Paragraph("Products", pageheaderFont));
	           
	           LineSeparator line = new LineSeparator();
	           line.setLineColor(headerTextColor);
	           preface.add(line);
	           
	           addEmptyLine(preface, 2);
	           document.add(preface);
	           
	           /************ Page Heading Ends*************/
	           
	           PdfPTable table = new PdfPTable(7);                       
	           
	   
	           PdfPCell cell = new PdfPCell(new Phrase("Product Source System",tableHeadFont));
	           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	           cell.setBackgroundColor(tableHeadBg);
	           table.addCell(cell);
	           
	           cell = new PdfPCell(new Phrase("Substance generic name",tableHeadFont));
	           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	           cell.setBackgroundColor(tableHeadBg);
	           table.addCell(cell);
	           
	           cell = new PdfPCell(new Phrase("Substance J&J Number",tableHeadFont));
	           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	           cell.setBackgroundColor(tableHeadBg);
	           table.addCell(cell);
	           	
	       /*    if (sector.equalsIgnoreCase("Consumer"))
	           {
	           cell = new PdfPCell(new Phrase("Active Ingredients",tableHeadFont));
	           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	           cell.setBackgroundColor(tableHeadBg);
	           table.addCell(cell);
	           }
	           else{
	        	   cell = new PdfPCell(new Phrase("Generic Ingredients",tableHeadFont));
	               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	               cell.setBackgroundColor(tableHeadBg);
	               table.addCell(cell);
	           }*/
	
	           cell = new PdfPCell(new Phrase("Dosage Form",tableHeadFont));
	           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	           cell.setBackgroundColor(tableHeadBg);
	           table.addCell(cell);
	           
	           cell = new PdfPCell(new Phrase("Primary Product Indicator",tableHeadFont));
	           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	           cell.setBackgroundColor(tableHeadBg);
	           table.addCell(cell);
	           
	        
	           
	           cell = new PdfPCell(new Phrase("Product Route Of Administration",tableHeadFont));
	           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	           cell.setBackgroundColor(tableHeadBg);
	           table.addCell(cell);
	           
	           cell = new PdfPCell(new Phrase("US Substance Name",tableHeadFont));
	           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	           cell.setBackgroundColor(tableHeadBg);
	           table.addCell(cell);
	                                                                                                           
	           table.setHeaderRows(1);
	           
	           if (phrmaproductList.size()>0){                                
	           for (int i = 0; i < phrmaproductList.size(); i++) {                                                 
	                           
	                           HashMap<String, String> product_pharma = phrmaproductList.get(i);                                     
	                           Color currentRowBg = mainBg;
	                           if(i%2!=0){
	                                           currentRowBg = tableCellBg;                                                                       
	                           }
	                           
	                           cell = new PdfPCell(new Phrase(product_pharma.get("source"),tableContent));
	                           cell.setBackgroundColor(currentRowBg);
	                           table.addCell(cell);
	                           
	                           cell = new PdfPCell(new Phrase(product_pharma.get("activeIngredient"),tableContent));
	                           cell.setBackgroundColor(currentRowBg);
	                           table.addCell(cell);
	                           
	                           cell = new PdfPCell(new Phrase(product_pharma.get("substanceJnJNumber"),tableContent));
	                           cell.setBackgroundColor(currentRowBg);
	                           table.addCell(cell);
	                           
	                           cell = new PdfPCell(new Phrase(product_pharma.get("dosageForm"),tableContent));
	                           cell.setBackgroundColor(currentRowBg);
	                           table.addCell(cell);
	                           
	                           cell = new PdfPCell(new Phrase(product_pharma.get("primaryProductIndicator"),tableContent));
	                           cell.setBackgroundColor(currentRowBg);
	                           table.addCell(cell);
	                           
	                       
	                           cell = new PdfPCell(new Phrase(product_pharma.get("productRouteOfAdministration"),tableContent));
	                           cell.setBackgroundColor(currentRowBg);
	                           table.addCell(cell);
	                           
	                           cell = new PdfPCell(new Phrase(product_pharma.get("usSubstanceName"),tableContent));
	                           cell.setBackgroundColor(currentRowBg);
	                           table.addCell(cell);
	                                                                                           
	           }
	           }
	           else 
	           {
	                           
	                           addEmptytableRow(table,1,7);                                                  
	                           table.addCell(cell);
	                           
	           }
	
	           table.setWidthPercentage(100);
	           document.add(table);
	           
	           
	} catch (DocumentException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	}
	
	}
	   
	   private static void setupInfoComments(Document document,ArrayList<HashMap<String, String>> comments)
	                                   throws BadElementException {
	                   
	   
	                   try {
	                            
	                	   
	                	   BaseFont baseFontJjar = null;
		               		try {
		               			baseFontJjar = getBaseFont();
		               		} catch (IOException e) {
		               			// TODO Auto-generated catch block
		               			e.printStackTrace();
		               		}
	                                                                    
	                                   
		               		Font pageheaderFont = new Font(baseFontJjar, 14, Font.BOLD,sectionHeadColor);
		               		Font tableContent = new Font(baseFontJjar, 8, Font.NORMAL,tableContentColor);
		               		Font tableHeadFont = new Font(baseFontJjar, 8, Font.NORMAL,Color.WHITE);
	                                   
	                       
	                                  
	                                   
	                                   Paragraph preface = new Paragraph();                                                                                    
	                                   preface.setAlignment(Element.ALIGN_LEFT);      
	                                   preface.setLeading(10);
	                                   preface.add(new Paragraph("Comments", pageheaderFont));
	                                   
	                                   LineSeparator line = new LineSeparator();
	                                   line.setLineColor(headerTextColor);
	                                   preface.add(line);
	                                   
	                                   addEmptyLine(preface, 2);
	                                   document.add(preface);
	                                   
	                                   PdfPTable table = new PdfPTable(4);                       
	                                   
	                       
	                                   PdfPCell cell = new PdfPCell(new Phrase("User",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("Role",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("Comments",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	                                   
	                                   cell = new PdfPCell(new Phrase("Timestamp",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	                                   
	                                   
	                                                                                                                                   
	                                   table.setHeaderRows(1);
	                                   
	                                                                                   
	                                   if(comments.size()>0){
	                                                   for (int i = 0; i < comments.size(); i++) {                                                   
	                                                                   
	                                                                   HashMap<String, String> comments1 = comments.get(i);                                              
	                                                                   Color currentRowBg = mainBg;
	                                                                   if(i%2!=0){
	                                                                                   currentRowBg = tableCellBg;                                                                       
	                                                                   }
	                                                                   
	                                                                   cell = new PdfPCell(new Phrase(comments1.get("user"),tableContent));
	                                                                   cell.setBackgroundColor(currentRowBg);
	                                                                   table.addCell(cell);
	                                                                   
	                                                                   cell = new PdfPCell(new Phrase(comments1.get("role"),tableContent));
	                                                                   cell.setBackgroundColor(currentRowBg);
	                                                                   table.addCell(cell);
	                                                                   
	                                                                   cell = new PdfPCell(new Phrase(comments1.get("comment"),tableContent));
	                                                                   cell.setBackgroundColor(currentRowBg);
	                                                                   table.addCell(cell);
	                                                                   
	                                                                   cell = new PdfPCell(new Phrase(comments1.get("timestamp"),tableContent));
	                                                                   cell.setBackgroundColor(currentRowBg);
	                                                                   table.addCell(cell);
	                                                                   
	                                                                                                                                                                                   
	                                                   }
	                                   }
	                                   else {
	                                                   
	                                                   addEmptytableRow(table,1,4);                                                  
	                                                   table.addCell(cell);
	                                                   
	                                   }
	   
	                                   
	                                   table.setWidthPercentage(100);
	                                   document.add(table);
	                                   
	                                   
	                   } catch (DocumentException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
	                   }
	   
	   }
	   
	   
	   
	   private static void setupInfoAudit(Document document,ArrayList<HashMap<String, String>> audit)
	                                   throws BadElementException {
	                   
	   
	                   try {
	                	   
	                	   BaseFont baseFontJjar = null;
		               		try {
		               			baseFontJjar = getBaseFont();
		               		} catch (IOException e) {
		               			// TODO Auto-generated catch block
		               			e.printStackTrace();
		               		}
	                                                                    
	                                   
		               		Font pageheaderFont = new Font(baseFontJjar, 14, Font.BOLD,sectionHeadColor);
		               		Font tableContent = new Font(baseFontJjar, 8, Font.NORMAL,tableContentColor);
		               		Font tableHeadFont = new Font(baseFontJjar, 8, Font.NORMAL,Color.WHITE);
	                         
	                                   
	                                   /************ Page Heading Starts*************/
	                	   
	                                   if(!PDF.equalsIgnoreCase("audit")){
	                                	   
		                                   Paragraph preface = new Paragraph();                                                                                    
		                                   preface.setAlignment(Element.ALIGN_LEFT);      
		                                   preface.setLeading(10);
		                                   preface.add(new Paragraph("Audit Trail", pageheaderFont));
		                                   
		                                   LineSeparator line = new LineSeparator();
		                                   line.setLineColor(headerTextColor);
		                                   preface.add(line);
		                                   
		                                   addEmptyLine(preface, 4);
		                                   document.add(preface);
		                             
	                                   }                           
	                                   /************ Page Heading Ends*************/
	                                   
	                                   
	                                   
	                                   PdfPTable table = new PdfPTable(4);                       
	                                   
	                       
	                                   PdfPCell cell = new PdfPCell(new Phrase("User Name",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("User ID",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	   
	                                   cell = new PdfPCell(new Phrase("Event Description",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	                                   
	                                   cell = new PdfPCell(new Phrase("Timestamp",tableHeadFont));
	                                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                                   cell.setBackgroundColor(tableHeadBg);
	                                   table.addCell(cell);
	                                   
	                                                                                                   
	                                   table.setHeaderRows(1);
	                                   
	                                   if(audit.size()>0){                                             
	                                   for (int i = 0; i < audit.size(); i++) {                                                              
	                                                   
	                                                   HashMap<String, String> auditTrail = audit.get(i);                                              
	                                                   Color currentRowBg = mainBg;
	                                                   if(i%2!=0){
	                                                                   currentRowBg = tableCellBg;                                                                       
	                                                   }
	                                                   
	                                                   cell = new PdfPCell(new Phrase(auditTrail.get("user"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                   
	                                                   cell = new PdfPCell(new Phrase(auditTrail.get("userId"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                   
	                                                   cell = new PdfPCell(new Phrase(auditTrail.get("eventDescription"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                   
	                                                   cell = new PdfPCell(new Phrase(auditTrail.get("timeStamp"),tableContent));
	                                                   cell.setBackgroundColor(currentRowBg);
	                                                   table.addCell(cell);
	                                                   
	                                                   
	                                   }
	                                   }              
	                                                   else {
	                                                                   
	                                                                   addEmptytableRow(table,1,4);                                                  
	                                                                   table.addCell(cell);
	                                                                   
	                                                   }
	                                                   
	                                   
	                                   table.setWidthPercentage(100);
	                                   document.add(table);
	                                   
	                                   
	                   } catch (DocumentException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
	                   }
	   
	   }
	   
	   
	   
	   // function for audit trail tab
	   
	   private static void setupInfoAuditTab(Document document,Map<String, String> mp,ArrayList<HashMap<String, String>> audit)
	           throws BadElementException {
	
	
	try {
	   
	   BaseFont baseFontJjar = null;
		try {
			baseFontJjar = getBaseFont();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	                                            
	           
		Font pageheaderFont = new Font(baseFontJjar, 14, Font.BOLD,sectionHeadColor);
		Font LabelFont = new Font(baseFontJjar, 10, Font.NORMAL,labelColor);
		Font tableContent = new Font(baseFontJjar, 8, Font.NORMAL,tableContentColor);
		Font tableHeadFont = new Font(baseFontJjar, 8, Font.NORMAL,Color.WHITE);
	 
	           
	           /************ Page Heading Starts*************/
	   
	           if(!PDF.equalsIgnoreCase("audit")){
	        	   
	               Paragraph preface = new Paragraph();                                                                                    
	               preface.setAlignment(Element.ALIGN_LEFT);      
	               preface.setLeading(10);
	               preface.add(new Paragraph("Audit Trail", pageheaderFont));
	               
	               LineSeparator line = new LineSeparator();
	               line.setLineColor(headerTextColor);
	               preface.add(line);
	               
	               addEmptyLine(preface, 4);
	               document.add(preface);
	               
	           }
	           else{
	               
	               
	        	   Paragraph preface = new Paragraph();                                                                                    
	               preface.setAlignment(Element.ALIGN_LEFT);      
	               preface.setLeading(10);
	               preface.add(new Paragraph("Filter Criteria", pageheaderFont));
	               
	               LineSeparator line = new LineSeparator();
	               line.setLineColor(headerTextColor);
	               preface.add(line);
	               
	               addEmptyLine(preface, 2);
	               document.add(preface);
	               
	           }
	               PdfPTable table = new PdfPTable(2);                       
	               PdfPCell cell;
	               
	              
	               cell = new PdfPCell(new Phrase("Event:",LabelFont));
	               cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	               cell.setBorder(Rectangle.NO_BORDER);
	               table.addCell(cell);
	
	               cell = new PdfPCell(new Phrase("User:",LabelFont));
	               cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	               cell.setBorder(Rectangle.NO_BORDER);
	               table.addCell(cell);
	               
	               
	               cell = new PdfPCell(new Phrase(mp.get("eventType"),tableContent));
	               cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	               cell.setBorder(Rectangle.NO_BORDER);
	               table.addCell(cell);
	
	               cell = new PdfPCell(new Phrase(mp.get("userName"),tableContent));
	               cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	               cell.setBorder(Rectangle.NO_BORDER);
	               table.addCell(cell);
	               
	               
	               addEmptytableRow(table,2,2);
	               
	               cell = new PdfPCell(new Phrase("From:",LabelFont));
	               cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	               cell.setBorder(Rectangle.NO_BORDER);
	               table.addCell(cell);
	
	               cell = new PdfPCell(new Phrase("To:",LabelFont));
	               cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	               cell.setBorder(Rectangle.NO_BORDER);
	               table.addCell(cell);
	               
	               
	               cell = new PdfPCell(new Phrase(mp.get("FromDate"),tableContent));
	               cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	               cell.setBorder(Rectangle.NO_BORDER);
	               table.addCell(cell);
	
	               cell = new PdfPCell(new Phrase(mp.get("ToDate"),tableContent));
	               cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	               cell.setBorder(Rectangle.NO_BORDER);
	               table.addCell(cell);
	               
	               
	               addEmptytableRow(table,2,2);
	               
	               cell = new PdfPCell(new Phrase("List:",LabelFont));
	               cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	               cell.setBorder(Rectangle.NO_BORDER);
	               table.addCell(cell);
	
	               cell = new PdfPCell(new Phrase("Rule Variable:",LabelFont));
	               cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	               cell.setBorder(Rectangle.NO_BORDER);
	               table.addCell(cell);
	               
	               
	               cell = new PdfPCell(new Phrase(mp.get("referenceDataList"),tableContent));
	               cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	               cell.setBorder(Rectangle.NO_BORDER);
	               table.addCell(cell);
	
	               cell = new PdfPCell(new Phrase(mp.get("ruleVariable"),tableContent));
	               cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	               cell.setBorder(Rectangle.NO_BORDER);
	               table.addCell(cell);
	               
	               
	               addEmptytableRow(table,2,2);
	               document.add(table);
	               
	               
	               Paragraph preface = new Paragraph();                                                                                    
	               preface.setAlignment(Element.ALIGN_LEFT);      
	               preface.setLeading(10);
	               preface.add(new Paragraph("Search results", pageheaderFont));
	               
	               LineSeparator  line = new LineSeparator();
	               line.setLineColor(headerTextColor);
	               preface.add(line);
	               
	               addEmptyLine(preface, 2);
	               document.add(preface);
	               
	           
	
	                                      
	           /************ Page Heading Ends*************/
	           
	           
	           
	            table = new PdfPTable(4);                       
	           
	   
	           cell = new PdfPCell(new Phrase("User Name",tableHeadFont));
	           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	           cell.setBackgroundColor(tableHeadBg);
	           table.addCell(cell);
	
	           cell = new PdfPCell(new Phrase("User ID",tableHeadFont));
	           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	           cell.setBackgroundColor(tableHeadBg);
	           table.addCell(cell);
	
	           cell = new PdfPCell(new Phrase("Event Description",tableHeadFont));
	           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	           cell.setBackgroundColor(tableHeadBg);
	           table.addCell(cell);
	           
	           cell = new PdfPCell(new Phrase("Timestamp",tableHeadFont));
	           cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	           cell.setBackgroundColor(tableHeadBg);
	           table.addCell(cell);
	           
	                                                                           
	           table.setHeaderRows(1);
	           
	           if(audit.size()>0){                                             
	           for (int i = 0; i < audit.size(); i++) {                                                              
	                           
	                           HashMap<String, String> auditTrail = audit.get(i);                                              
	                           Color currentRowBg = mainBg;
	                           if(i%2!=0){
	                                           currentRowBg = tableCellBg;                                                                       
	                           }
	                           
	                           cell = new PdfPCell(new Phrase(auditTrail.get("user"),tableContent));
	                           cell.setBackgroundColor(currentRowBg);
	                           table.addCell(cell);
	                           
	                           cell = new PdfPCell(new Phrase(auditTrail.get("userId"),tableContent));
	                           cell.setBackgroundColor(currentRowBg);
	                           table.addCell(cell);
	                           
	                           cell = new PdfPCell(new Phrase(auditTrail.get("eventDescription"),tableContent));
	                           cell.setBackgroundColor(currentRowBg);
	                           table.addCell(cell);
	                           
	                           cell = new PdfPCell(new Phrase(auditTrail.get("timeStamp"),tableContent));
	                           cell.setBackgroundColor(currentRowBg);
	                           table.addCell(cell);
	                           
	                           
	           }
	           }              
	                           else {
	                                           
	                                           addEmptytableRow(table,1,4);                                                  
	                                           table.addCell(cell);
	                                           
	                           }
	                           
	           
	           table.setWidthPercentage(100);
	           document.add(table);
	           
	           
	} catch (DocumentException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	}
	
	}
	   
	   
	   // TODO Auto-generated method stub
	   
	/*   private static void executionEtc(Document document,
	                                   HashMap<String, HashMap<String, String>> executionEtcMap){
	   
	   try {
	                   
	                                                            
	                   
	                   
	                   HashMap<String, String> mp = executionEtcMap.get("pediatricInfo");
	                   
	                   
	                   
	                   
	                   
	                 
	                   
	                   
	                   Paragraph preface = new Paragraph();                                                                                    
	                   preface.setAlignment(Element.ALIGN_LEFT);      
	                   preface.setLeading(10);
	                   preface.add(new Paragraph("Execution Pediatric Information", pageheaderFont));
	                   
	                   LineSeparator line = new LineSeparator();
	                   line.setLineColor(headerTextColor);
	                   preface.add(line);
	                   
	                   addEmptyLine(preface, 2);
	                   document.add(preface);
	                   
	                   
	                   
	                   
	                   PdfPTable table = new PdfPTable(3);                       
	                   
	                   
	                   PdfPCell cell = new PdfPCell(new Phrase("Does the activity involve a subject under 1 year old?",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase("Subject Age Range Minimum:",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase("Subject Age Range Maximum:",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   
	                   cell = new PdfPCell(new Phrase(mp.get("pedSubject1YrOld"),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase(mp.get("pedMinAge"),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase(mp.get("pedMaxAge"),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   addEmptytableRow(table,5,3);
	                   
	                   document.add(table);
	                   
	                   
	                   
	                   //Execution Dates Information
	                   
	                   
	                   mp = executionEtcMap.get("datesInfo");
	                   
	                   
	                   
	    
	                   
	                   
	                   preface = new Paragraph();                                                                                        
	                   preface.setAlignment(Element.ALIGN_LEFT);      
	                   preface.setLeading(10);
	                   preface.add(new Paragraph("Execution Dates Information", pageheaderFont));
	                   
	                   line = new LineSeparator();
	                   line.setLineColor(headerTextColor);
	                   preface.add(line);
	                   
	                   addEmptyLine(preface, 2);
	                   document.add(preface);               
	                   
	                  
	                   
	                   
	                   table = new PdfPTable(3);                            
	                   
	                   
	                   cell = new PdfPCell(new Phrase("Actual Start Date:",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase("Expected End Date:",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase("Actual End Date:",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   
	                   cell = new PdfPCell(new Phrase(mp.get("acStDt"),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase(mp.get("exEndDt"),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase(mp.get("AcEndDt"),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   addEmptytableRow(table,5,3);
	                   
	                   document.add(table);
	                   
	                   
	                   //Execution Approved/Autorized Product Information
	                   
	                   mp = executionEtcMap.get("approvedProdInfo");
	                   
	                   
	                   
	                   
	                   
	                                   preface = new Paragraph();                                                                                         
	                                   preface.setAlignment(Element.ALIGN_LEFT);      
	                                   preface.setLeading(10);
	                                   preface.add(new Paragraph("Execution Approved/Authorized Product Information", pageheaderFont));
	                                   
	                                   line = new LineSeparator();
	                                   line.setLineColor(headerTextColor);
	                                   preface.add(line);
	                                   
	                                   addEmptyLine(preface, 2);
	                                   document.add(preface);               
	                   
	                  
	                   
	                   
	                   table = new PdfPTable(3);                            
	                   
	                   
	                   cell = new PdfPCell(new Phrase("Health Outcomes Study?",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase("Health Economics Study?",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase("Epidemiology Study?",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   
	                   
	                   
	                   cell = new PdfPCell(new Phrase(mp.get("healthOutcomesStd"),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase(mp.get("healthEcoStd"),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase(mp.get("epidemiologyStd"),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   
	                   
	                   addEmptytableRow(table,3,3);
	                   
	                   cell = new PdfPCell(new Phrase("Drug Utilization Study?",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   
	                   cell = new PdfPCell(new Phrase(""));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   cell = new PdfPCell(new Phrase(""));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   
	                   
	                   cell = new PdfPCell(new Phrase(mp.get("drugUtiStd"),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   
	                   
	                   addEmptytableRow(table,5,3);
	                   
	                   document.add(table);
	                   
	                   
	                   
	                   //Execution PostMarketing Information
	                   
	                   mp = executionEtcMap.get("postMarketingInfo");
	                   
	                   
	                   
	
	                   
	                   preface = new Paragraph();                                                                                         
	                   preface.setAlignment(Element.ALIGN_LEFT);      
	                   preface.setLeading(10);
	                   preface.add(new Paragraph("Execution Postmarketing Information", pageheaderFont));
	                   
	                   line = new LineSeparator();
	                   line.setLineColor(headerTextColor);
	                   preface.add(line);
	                   
	                   addEmptyLine(preface, 2);
	                   document.add(preface);               
	                   
	                  
	                   
	                   
	                   table = new PdfPTable(3);                            
	                   
	                   
	                   cell = new PdfPCell(new Phrase("Postmarketing Main Objective:",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase("Is this a Health Authority required/imposed/mandated Post-marketing Commitment (PMC) or a voluntary Post-marketing study that the MAH has agreed to conduct?",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase("PMC Applicable Authorities:",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   
	                   
	                   
	                   cell = new PdfPCell(new Phrase(mp.get("mainObj"),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase(mp.get("comIndicator"),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	   
	                   cell = new PdfPCell(new Phrase(mp.get("appAuth"),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   addEmptytableRow(table,3,3);
	                   
	                   //table = new PdfPTable(3); 
	                   
	                   cell = new PdfPCell(new Phrase("Post Authorization Safety Study (PASS):",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   cell = new PdfPCell(new Phrase("",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   cell = new PdfPCell(new Phrase("",LabelFont));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   
	                   cell = new PdfPCell(new Phrase(mp.get("pass"),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   cell = new PdfPCell(new Phrase(mp.get(""),tableContent));
	                   cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                   cell.setBorder(Rectangle.NO_BORDER);
	                   table.addCell(cell);
	                   
	                   document.add(table);
	                   
	                   
	                   
	                   
	                   
	   } catch (DocumentException e) {
	                   // TODO Auto-generated catch block
	                   e.printStackTrace();
	   }
	   
	   
	   }*/
	   
	   private static void addEmptyLine(Paragraph paragraph, int number) {
	                   for (int i = 0; i < number; i++) {
	                                   paragraph.add(new Paragraph(" "));
	                   }
	   }
	   
	   private static void addEmptytableRow(PdfPTable table, int row, int column) {
	                   
	                   for (int i = 0; i < row; i++) {
	                                   for (int j = 0; j < column; j++) {
	                                                   
	                                                   PdfPCell cell = new PdfPCell(new Phrase(""));
	                                                   cell.setBorder(Rectangle.NO_BORDER);
	                                                   table.addCell(cell);
	                                                   
	                                   }
	                                   
	                   }
	                   
	                   
	   }
	   public static String toTitleCase(String input) {
	       String[] arr = input.split(" ");
	       StringBuffer sb = new StringBuffer();
	   
	       for (int i = 0; i < arr.length; i++) {
	           sb.append(Character.toUpperCase(arr[i].charAt(0)))
	              .append(arr[i].substring(1)).append(" ");
	       }          
	       return sb.toString().trim();
	   }
			
		
	// --- <<IS-END-SHARED>> ---
}

