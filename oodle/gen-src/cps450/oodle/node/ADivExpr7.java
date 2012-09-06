/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class ADivExpr7 extends PExpr7
{
    private PExpr7 _expr7_;
    private TDivOp _divOp_;
    private PExpr8 _expr8_;

    public ADivExpr7()
    {
        // Constructor
    }

    public ADivExpr7(
        @SuppressWarnings("hiding") PExpr7 _expr7_,
        @SuppressWarnings("hiding") TDivOp _divOp_,
        @SuppressWarnings("hiding") PExpr8 _expr8_)
    {
        // Constructor
        setExpr7(_expr7_);

        setDivOp(_divOp_);

        setExpr8(_expr8_);

    }

    @Override
    public Object clone()
    {
        return new ADivExpr7(
            cloneNode(this._expr7_),
            cloneNode(this._divOp_),
            cloneNode(this._expr8_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADivExpr7(this);
    }

    public PExpr7 getExpr7()
    {
        return this._expr7_;
    }

    public void setExpr7(PExpr7 node)
    {
        if(this._expr7_ != null)
        {
            this._expr7_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr7_ = node;
    }

    public TDivOp getDivOp()
    {
        return this._divOp_;
    }

    public void setDivOp(TDivOp node)
    {
        if(this._divOp_ != null)
        {
            this._divOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._divOp_ = node;
    }

    public PExpr8 getExpr8()
    {
        return this._expr8_;
    }

    public void setExpr8(PExpr8 node)
    {
        if(this._expr8_ != null)
        {
            this._expr8_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr8_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expr7_)
            + toString(this._divOp_)
            + toString(this._expr8_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expr7_ == child)
        {
            this._expr7_ = null;
            return;
        }

        if(this._divOp_ == child)
        {
            this._divOp_ = null;
            return;
        }

        if(this._expr8_ == child)
        {
            this._expr8_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expr7_ == oldChild)
        {
            setExpr7((PExpr7) newChild);
            return;
        }

        if(this._divOp_ == oldChild)
        {
            setDivOp((TDivOp) newChild);
            return;
        }

        if(this._expr8_ == oldChild)
        {
            setExpr8((PExpr8) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
