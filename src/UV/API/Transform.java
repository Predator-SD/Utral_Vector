package UV.API;
public class Transform {
	public static void Show(double[] vec){
		int l=vec.length;
		for(int i=0;i<l;i++){
			if(i==0){
				System.out.print('[');
			}
			System.out.print(vec[i]);
			if(i!=(l-1)){
				System.out.print(',');
			}
			if(i==(l-1)){
				System.out.print(']');
			}
		}
	}
	public static double[] Cross3D(double[] u, double[] v){
		double[] Res=new double[3];
		double x=u[1]*v[2]-v[1]*u[2];
		double y=u[2]*v[0]-v[2]*u[0];
		double z=u[0]*v[1]-u[1]*v[0];
		Res[0]=x;
		Res[1]=y;
		Res[2]=z;
		return Res;
	}
	public static double Dot3D(double[] u, double[] v){
		double Res;
		double p1=u[0]*v[0];
		double p2=u[1]*v[1];
		double p3=u[2]*v[2];
		Res=p1+p2+p3;
		return Res;
	}
	public static double[] Plus(double[] u, double[] v){
		if(u.length==v.length){
			int length=u.length;
			double[] Res=new double[length];
			for(int i=0;i<length;i++){
				Res[i]=u[i]+v[i];
			}
			return Res;
		}else{
			double[] Error=new double[1];
			Error[0]=0;
			return Error;
		}
	}
	public static double RTD(double rad){
		double deg=rad*(180/Math.PI);;
		return deg;
	}
	public static double arcsin(double sin){
		double rasin=Math.asin(sin);
		double dasin=RTD(rasin);
		return dasin;
	}
	public static double arccos(double cos){
		double racos=Math.asin(cos);
		double dacos=RTD(racos);
		return dacos;
	}
	public static double sind (double theta){
		double rad=theta*Math.PI/180;
		return Math.sin(rad);
	}
	public static double cosd (double theta){
		double rad=theta*Math.PI/180;
		return Math.cos(rad);
	}
    public static double[] Euler(double xt,double yt,double zt){
		double x=sind(yt/2)*sind(zt/2)*cosd(xt/2)+cosd(yt/2)*cosd(zt/2)*sind(xt/2);
		double y=cosd(yt/2)*sind(zt/2)*sind(xt/2)+sind(yt/2)*cosd(zt/2)*cosd(xt/2);
		double z=cosd(yt/2)*sind(zt/2)*cosd(xt/2)-sind(yt/2)*cosd(zt/2)*sind(xt/2);
		double w=cosd(yt/2)*cosd(zt/2)*cosd(xt/2)-sind(yt/2)*sind(zt/2)*sind(xt/2);
		double[] Quaternion=new double[4];
		Quaternion[0]=x;
		Quaternion[1]=y;
		Quaternion[2]=z;
		Quaternion[3]=w;
		return Quaternion;
	}
    public static double[] QtoV(double[] q){
    	double x=q[0];
    	double y=q[1];
    	double z=q[2];
    	double[] Res=new double[3];
    	Res[0]=x;
    	Res[1]=y;
    	Res[2]=z;
    	return Res;
    }
    public static double[] NxV(double num,double[] vec){
    	int l=vec.length;
    	double[] Res=new double[l];
    	for(int i=0;i<l;i++){
    		Res[i]=num*vec[i];
    	}
    	return Res;
    }
    public static double[] QxQ(double[] q1,double[] q2){
    	if(q1.length==4&&q2.length==4){
    	    double[] v1=new double[3];
    	    double[] v2=new double[3];
    	    v1=QtoV(q1);
    	    v2=QtoV(q2);
    	    double w1=q1[3];
    	    double w2=q2[3];
    	    double[] p1=new double[3];
    	    p1=Plus(Plus(Cross3D(v1,v2),NxV(w1,v2)),NxV(w2,v1));
    	    double p2=w1*w2-Dot3D(v1,v2);
    	    double[] Res=new double[4];
    	    Res[0]=p1[0];
    	    Res[1]=p1[1];
    	    Res[2]=p1[2];
    	    Res[3]=p2;
    	    return Res;
    	}else{
    		double[] err=new double[1];
    		err[0]=0;
    		return err;
    	}
    }
}
